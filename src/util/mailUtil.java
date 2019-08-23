package util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mailUtil {
	public static String host = "smtp.naver.com";
	public static String user = "dlxorhks93@naver.com";
	public static String password = "xorhks1520645tg!";
	public static Properties prop = new Properties();

	public static Session session;

	public mailUtil() {
		prop.put("mail.smtp.host", host);
		// 네이버 포트주소
		prop.put("mail.smtp.port", 587);
		// 구글 포트주소
		// prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		// prop.put("mail.smtp.ssl.enable", "true");
		// prop.put("mail.smtp.ssl.trust", host);

		session();
	}

	public void session() {
		session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
	}
}