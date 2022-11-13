package com.zcy.mail;

import javax.mail.*;
import java.security.Security;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

public class MailTest {

    public static void main(String[] args) throws MessagingException {

        // <连接邮件服务器>
        Store store = null;
        Folder folder = null;
        try {
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Properties prop = System.getProperties();
            prop.setProperty("mail.imap.ssl.trust", "*");
//            prop.setProperty("mail.imap.socketFactory.port", "993");
//            prop.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            prop.setProperty("mail.imap.ssl.enable", "true");
            Session session = Session.getInstance(prop);

            store = session.getStore("imap");
            store.connect("mail.qq.com", 993, "loan@qq.com", "23");

            folder = store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);

            Message[] messages = folder.getMessages();
            System.out.println(Arrays.asList(messages).stream().map(message -> {
                try {
                    return message.getSubject();
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList()));

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } finally {
//            folder.close(false);
//            store.close();
        }


    }
}
