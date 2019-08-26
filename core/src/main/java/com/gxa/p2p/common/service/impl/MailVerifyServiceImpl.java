package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Mailverify;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.MailverifyMapper;
import com.gxa.p2p.common.service.IMailService;
import com.gxa.p2p.common.service.IUserInfoService;
import com.gxa.p2p.common.util.MailFiled;
import com.gxa.p2p.common.util.SysConstant;
import com.gxa.p2p.common.util.UserContext;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

/**
 * 验证邮件相关的服务
 *
 * @author novo
 */
@Service
public class MailVerifyServiceImpl implements IMailService {


    @Autowired
    private MailverifyMapper mailVerifyMapper;

    @Autowired
    private IUserInfoService iUserInfoService;

    //简单值的注入
    @Value("${mail.applicationUrl}")
    private String applicationUrl;
    @Value("${mail.host}")
    private String host;

    public void sendVerifyEmail(String email) {
        //判断用户是否已经绑定邮件
        Userinfo userInfo = iUserInfoService.getUserInfoById(UserContext.getLoginInfo().getId());
        if (!userInfo.getIsBindEmail()) { //如果当前用户没有绑邮箱
            //生成一个UUID
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //构造邮件内容并且发送
            String content =
                    "<html>" +
                            "<head></head>" +
                            "<body>" +
                            "<h1>这是一封激活邮件,激活请点击以下链接，如果不是本人操作，请勿点击</h1>" +
                            "<h3><a href='http://localhost:8080/website/bindEmail.do?code=" + uuid + "'>" +
                            "http://localhost:8080/website/bindEmail.do?code=" + uuid +"</a></h3>" +
                            "有效期是：" + SysConstant.EMAIL_VALID_DAY + "天</body></html>";
            try {
                //System.out.println("发送邮件:" + content);
                sendMail(email, content, userInfo, uuid);

                //发送成功之后 创建一个MailVerify对象
                Mailverify mv = new Mailverify();
                mv.setLogininfoId(userInfo.getId());
                mv.setEmail(email);
                mv.setUuid(uuid);
                mv.setSendtime(new Date());
                mailVerifyMapper.insert(mv);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("发送验证邮件失败!");
            }
        }
    }

    //发送邮件方法
    private void sendMail(String email, String content, Userinfo userInfo, String uuid)
            throws MessagingException {

        // 指定发送邮件的主机smtp.qq.com(QQ)|smtp.163.com(网易)  这里需要继续扩展做判断分支处理

        Properties properties = System.getProperties();      // 获取系统属性
        properties.setProperty("mail.smtp.host", host);      // 设置邮件服务器
        properties.setProperty("mail.smtp.auth", "true");    // 打开认证
        try {
            //QQ邮箱需要下面这段代码，163邮箱不需要
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);

            // 1.获取默认session对象
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(MailFiled.mailName, MailFiled.mailCode); // 发件人邮箱账号、授权码
                }
            });

            // 2.创建邮件对象
            Message message = new MimeMessage(session);

            // 3.设置发件人
            message.setFrom(new InternetAddress(MailFiled.mailName));

            // 4.设置收件人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            // 5.设置邮件主题
            message.setSubject("国信安P2P验证邮件");


            message.setContent(content, "text/html;charset=UTF-8");

            // 7.发送邮件
            Transport.send(message);   // 阻塞方法
            System.out.println("邮件成功发送!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

