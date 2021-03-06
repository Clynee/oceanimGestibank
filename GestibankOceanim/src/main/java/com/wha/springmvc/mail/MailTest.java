package com.wha.springmvc.mail;

import java.sql.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import com.sun.mail.smtp.SMTPMessage;





public class MailTest {

	public static void main(String[] args) {
		Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	   props.put("mail.smtp.socketFactory.class",
	          "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "805");

	    Session session = Session.getDefaultInstance(props,new         javax.mail.Authenticator()
	                            {
	                                 @Override
	                                protected PasswordAuthentication     getPasswordAuthentication()
	                                {
	                return new PasswordAuthentication("gestibanktest@gmail.com","gestibank");
	                                }
	        });

	    try {

	        SMTPMessage message = new SMTPMessage(session);
	        message.setFrom(new InternetAddress("gestibanktest@gmail.com"));
	        message.setRecipients(Message.RecipientType.TO,
	                                 InternetAddress.parse( "b.aissamedjkoune@gmail.com" ));
	       // message.addRecipients(Message.RecipientType.CC, "noufel.abbassi@gmail.com");

	                     message.setSubject("Testing Subject");
	                     message.setText("coucou Noufel et celine notre banque ");
	                     //message.setContentID("This Is my First Mail Through Java");
	              //   message.setContent(o, type);
	                 //.setContent("This Is my First Mail Through Java");
	                     //();
	                     
	                  //   message.setHeader("X-Mailer", MAILER_VERSION);
	                    
	                   //  message.setContentID("This Is my First Mail Through Java");
	                     //setSentDate(new Date());
	                     
	                    // session.setDebug(debug);
	                     
	                     //Transport.send(message);

	                    message.setNotifyOptions(SMTPMessage.NOTIFY_SUCCESS);
	                    int returnOption = message.getReturnOption();

	                     System.out.println(returnOption);        
	                Transport.send(message);
	                System.out.println("sent");

	    }
	            catch (MessagingException e)
	            {
	        throw new RuntimeException(e);

	    }
	}

}
