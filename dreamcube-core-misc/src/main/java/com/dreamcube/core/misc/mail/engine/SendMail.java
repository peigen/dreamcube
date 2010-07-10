package com.dreamcube.core.misc.mail.engine;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dreamcube.core.common.tools.ArrayTool;
import com.dreamcube.core.common.tools.StringTool;

/**
 *                       
 * Filename: SendMail.java
 *
 * Description: 邮件发送
 *
 * Version: 0.1
 *
 * Author: peigen
 *
 * Email: peigen123@gmail.com
 *
 * Blog: http://peigen.info
 *
 *       
 * History:<br>
 *<li>Author: peigen</li>
 *<li>Date: 2010-4-22</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class SendMail {

    private static Logger log = LoggerFactory.getLogger(SendMail.class);

    public static void main(String[] args) {
        // 163
        String host = "smtp.163.com";
        String from = "peigen_peigen@163.com";
        String to = "peigen123@gmail.com";
        String username = "peigen_peigen";
        String password = "peigen*8";

        // gmail
        host = "smtp.gmail.com";
        from = "peigen123@gmail.com";
        to = "peigen123@gmail.com";
        username = "peigen123";
        password = "peigen*8";

        // BC && CC
        Map<String, String> others = new HashMap<String, String>();
        others.put("郝蕾", "hao.holly@gmail.com");
        others.put("李浩", "shotolee@gmail.com");

        String subject = "一封测试邮件";
        String mailConent = "哈哈dreamcube";

        try {
            sendAttachmentMail(host, subject, from, to, username, password, others, mailConent);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 通过Apache Mail组件带符件的邮件发送方法
     * 
     * @param host:发送时所使用的smtp服务器
     * @param from: 发送者名字
     * @param username: 发送者登陆服务器时的用户名
     * @param password: 发送者登陆服务器时的密码
     * @param to :接收者邮箱
     * @param subject: 邮件主题
     * @param mailConent：邮件内容
     * @return :是否发送成功
     */
    public static boolean sendAttachmentMail(String host, String subject, String from, String to,
                                             String username, String password,
                                             Map<String, String> others, String mailConent)
                                                                                           throws Exception {
        //创建附件对象
        EmailAttachment attachment = new EmailAttachment();

        /*附件的地址*/
        attachment.setPath("/home/peigen/temp/webxml的webservice的使用方法.pdf");

        //设定为附件
        attachment.setDisposition(EmailAttachment.ATTACHMENT);

        /*附件的描述*/
        attachment.setDescription("项目设计附件文档");

        /*附件的名称，必须和文件名一致*/
        attachment.setName("webxml的webservice的使用方法.pdf");

        /*new一个HtmlEmail发送对象*/
        HtmlEmail email = new HtmlEmail();
        email.setAuthentication(username, password);
        email.setHostName(host);
        email.addTo(to, from);

        // BC & CC
        for (String key : others.keySet()) {
            email.addCc(others.get(key), key);

        }

        email.setFrom(from);
        email.setSubject(subject);

        // gmail ssl
        isGmail(email, host);
        //注意，发送内容时，后面这段会让中文正常显示，否则乱码
        email.setCharset("GBK");

        /*邮件内容*/
        email.setHtmlMsg("<html>这是封测试附件邮件</html>");

        //添加附件对象
        email.attach(attachment);

        //        email.setContent(mailConent, "");

        //发送
        email.send();

        log.info("带符件的邮件发送成功！");

        return true;

    }

    /**
     * @param email
     * @param host
     */
    private static void isGmail(Email email, String host) {
        String[] hostArr = StringTool.split(host, ".");
        if (ArrayTool.contains(hostArr, "gmail")) {
            email.setSSL(true);
            email.setSmtpPort(465);
        }
    }
}
