package com.dreamcube.boot;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHandler;
import org.mortbay.jetty.servlet.ServletHolder;
import org.mortbay.jetty.servlet.ServletMapping;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * ���幤�̵Ĳ�����
 * 
 * @author holly Mar 31, 2010
 * 
 */
public class DreamCubeBootstrap {
	private Server server;
	private Context root;

	private String springContextLocation = "";
	private int serverPort = 8080;
	private URL[] subProjectPath;

	public DreamCubeBootstrap() {
	}

	public void preConfig() throws IOException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream(
				"dreamcubeconfig.properties"));
		serverPort = Integer.valueOf(properties.getProperty("jetty_port"));
		String projectHome = properties.getProperty("project_home");
		String projectModule = properties.getProperty("project_modules");

		URL propertiesURL = this.getClass().getClassLoader().getResource(
				"dreamcubeconfig.properties");
		System.out.println(propertiesURL.toExternalForm());

		subProjectPath = toSubjectPathURLs(projectHome, projectModule);
		URLClassLoader classLoader = (URLClassLoader) this.getClass()
				.getClassLoader();
		Method addURLMethod = URLClassLoader.class.getDeclaredMethod("addURL",
				new Class[] { URL.class });
		addURLMethod.setAccessible(true);
		for (URL url : subProjectPath) {
			addURLMethod.invoke(classLoader, url);
		}
		springContextLocation = new File(properties.getProperty("project_home")
				+ "/dreamcube-assemble/src/main/webapp/WEB-INF/dreamcube-servlet.xml").toURI().toURL().toExternalForm();
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
		subProjectPath = new URL[modules.length];
		int i = 0;
		for (String module : modules) {
			URL url = new File(projectHome, module + "/target/").toURI()
					.toURL();
			subProjectPath[i++] = url;

			System.out.println(url);
		}
		return subProjectPath;
	}

	public void init() throws IOException, ClassNotFoundException,
			SecurityException, IllegalArgumentException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {
		preConfig();
		server = new Server(serverPort);
		final String CONTEXTPATH = "/dreamcube";
		root = new Context(server, CONTEXTPATH, Context.SESSIONS);
		ServletHandler servletHandler = root.getServletHandler();
		DispatcherServlet ds = new DispatcherServlet();
		ds.setContextConfigLocation(springContextLocation);
		ServletHolder servletHolder = new ServletHolder(ds);
		servletHolder.setName("dreamcube");
		servletHandler.addServlet(servletHolder);

		ServletMapping servletMapping = new ServletMapping();
		servletMapping.setPathSpecs(new String[] { "*.html" });
		servletMapping.setServletName("dreamcube");
		servletHandler.addServletMapping(servletMapping);
	}

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
