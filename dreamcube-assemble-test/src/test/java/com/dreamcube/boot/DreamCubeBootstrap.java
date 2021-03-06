package com.dreamcube.boot;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ContextHandler;
import org.mortbay.jetty.handler.ContextHandlerCollection;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHandler;
import org.mortbay.jetty.servlet.ServletHolder;
import org.mortbay.jetty.servlet.ServletMapping;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 整体工程的测试类
 * 
 * @author holly Mar 31, 2010
 * 
 */
public class DreamCubeBootstrap {
    private Server         server;
    private Context        servletContext;
    private ContextHandler resourceContext;

    private String         contextLocation       = "";
    private String         springContextLocation = "";
    private int            serverPort            = 8080;
    private URL[]          subProjectPath;

    public DreamCubeBootstrap() {
    }

    /**
     * 配置端口，依赖工程等需要的东西
     * 
     * @throws IOException
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public void preConfig() throws IOException, SecurityException, NoSuchMethodException,
                           IllegalArgumentException, IllegalAccessException,
                           InvocationTargetException {
        // 读取配置文件
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader()
            .getResourceAsStream("dreamcube-config.properties"));
        URL propertiesURL = this.getClass().getClassLoader()
            .getResource("dreamcube-config.properties");
        System.out.println(propertiesURL.toExternalForm());

        // 获取需要启动的端口
        serverPort = Integer.valueOf(properties.getProperty("jetty_port"));
        // 总工程的路径
        String projectHome = loadHostName(properties);
        // 需要加载的module
        String projectModule = properties.getProperty("project_modules");
        // 将工程module加载到类路径
        subProjectPath = toSubjectPathURLs(projectHome, projectModule);
        URLClassLoader classLoader = (URLClassLoader) this.getClass().getClassLoader();
        // 设置classloader的类路径
        Method addURLMethod = URLClassLoader.class.getDeclaredMethod("addURL",
            new Class[] { URL.class });
        addURLMethod.setAccessible(true);
        for (URL url : subProjectPath) {
            addURLMethod.invoke(classLoader, url);
        }
        // 读取springd的context路径
        springContextLocation = new File(
            loadHostName(properties)
                    + "/dreamcube-assemble/src/main/webapp/WEB-INF/dreamcube-servlet.xml").toURI()
            .toURL().toExternalForm();
        StringBuffer springContextBuffer = new StringBuffer(springContextLocation);
        springContextBuffer.append(",classpath*:spring/*.xml");
        springContextLocation = springContextBuffer.toString();

        URL contextLocationURL = new File(loadHostName(properties)
                                          + "/dreamcube-assemble/src/main/webapp").toURI().toURL();

        // 增加webapp到classpath
        addURLMethod.invoke(classLoader, contextLocationURL);
        contextLocation = contextLocationURL.toExternalForm();
    }

    /**
     * translate all project modules to URLs
     * 
     * @param projectHome
     * @param projectModule
     * @return URL[]
     * @throws MalformedURLException
     */
    private URL[] toSubjectPathURLs(String projectHome, String projectModule)
                                                                             throws MalformedURLException {
        String[] modules = projectModule.split(",");
        subProjectPath = new URL[modules.length + 1];
        int i = 0;
        for (String module : modules) {
            URL url = new File(projectHome, module + "/target/").toURI().toURL();
            subProjectPath[i++] = url;

            System.out.println(url);
        }
        subProjectPath[i++] = new File(projectHome, "dreamcube-assemble" + "/src/main/resources/")
            .toURI().toURL();
        System.out.println(subProjectPath[--i]);
        return subProjectPath;
    }

    /**
     * 初始化init方法
     * 
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public void init() throws IOException, ClassNotFoundException, SecurityException,
                      IllegalArgumentException, NoSuchMethodException, IllegalAccessException,
                      InvocationTargetException {
        preConfig();
        server = new Server(serverPort);
        final String CONTEXTPATH = "/dreamcube";
        servletContext = new Context(server, CONTEXTPATH, Context.SESSIONS);
        servletContext.setResourceBase(contextLocation);
        // servletContext.setAttribute("contextConfigLocation", value);
        // 增加处理静态文件的handler
        resourceContext = new Context();
        resourceContext.setContextPath("/");
        resourceContext.setResourceBase(contextLocation);
        resourceContext.setHandler(new ResourceHandler());

        // 增加servlet handler
        ServletHandler servletHandler = servletContext.getServletHandler();
        DispatcherServlet ds = new DispatcherServlet();
        ds.setContextConfigLocation(springContextLocation);
        ServletHolder servletHolder = new ServletHolder(ds);
        servletHolder.setName("dreamcube");
        servletHandler.addServlet(servletHolder);
        // 设置servlet mapping
        ServletMapping servletMapping = new ServletMapping();
        servletMapping.setPathSpecs(new String[] { "*.html", "*.json", "*.checkcode" });
        servletMapping.setServletName("dreamcube");
        servletHandler.addServletMapping(servletMapping);

        // 设置server handler
        ContextHandlerCollection handlerCollection = new ContextHandlerCollection();
        handlerCollection.setHandlers(new Handler[] { resourceContext, servletContext });
        server.setHandler(handlerCollection);

    }

    /**
     * 启动方法
     */
    public void start() {
        try {
            init();
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String loadHostName(Properties properties) {
        String hostname = "";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            hostname = addr.getHostName().toString();// 获得本机名称
            if (hostname.equals("peigen-ThinkPad-L412")) {

                hostname = properties.getProperty("peigen_latop_home");

            } else if (hostname.equals("peigen-desktop")) {

                hostname = properties.getProperty("peigen_desktop_home");

            } else {

                hostname = properties.getProperty("holly_project_home");
            }
            // TODO holly add
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hostname;
    }

    /**
     * the main method
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new DreamCubeBootstrap().start();
    }

}