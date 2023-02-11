package com.user.registration;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class JavaSendEmail {
	public void sendMail(String recepient) {
		System.out.println("sending email..................");
		Properties properties = new Properties();
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.connectiontimout","5000");
		properties.put("mail.smtp.timout","5000");
		properties.put("mail.smtp.writetimout","5000");
		
		//sender details
		String username ="ragunath0401@gmail.com";
		String password ="trxlgebgmdafqjvy";
		
		//common stuff to create session object -- credentials
		
		Session session = Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				 return new PasswordAuthentication(username,password);
				}
			});
		
			Message message=prepareMessage(session,username,recepient);
			try {
				Transport.send(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Sent Successfully...."+recepient);
		}
	
	
	// THIS IS THE MESSAGE SETTINGS
	private static Message prepareMessage(Session session, String username, String recepient) {
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(username));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("testing............");
			message.setText("Hello ,/n test mail from java");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		


