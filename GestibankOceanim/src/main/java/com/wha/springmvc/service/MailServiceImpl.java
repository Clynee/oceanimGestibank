package com.wha.springmvc.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.wha.springmvc.entities.Notification;


@Service("mailService")
public class MailServiceImpl implements MailService {

	
	
	
    @Autowired
    JavaMailSender mailSender;
	@Override
	public void sendEmail(Object object) {
		// TODO Auto-generated method stub
		
		
		Notification order = (Notification) object;
		 
//	        MimeMessagePreparator preparator = getMessagePreparator(order);
//	 
//	        try {
//	            mailSender.send(preparator);
//	            System.out.println("Message Send...Hurrey");
//	        } catch (MailException ex) {
//	            System.err.println(ex.getMessage());
//	        }
//	        
	        
	        MimeMessagePreparator preparator = getContentWtihAttachementMessagePreparator(order);
	        
	        try {
	            mailSender.send(preparator);
	            System.out.println("Message With Attachement has been sent.............................");
	            preparator = getContentAsInlineResourceMessagePreparator(order);
	            mailSender.send(preparator);
	            System.out.println("Message With Inline Resource has been sent.........................");
	        } catch (MailException ex) {
	            System.err.println(ex.getMessage());
	        }
	}
	
	
	
	
	////////////////////////////////
	
//	 private MimeMessagePreparator getMessagePreparator(final Notification notif) {
//		 
//	        MimeMessagePreparator preparator = new MimeMessagePreparator() {
//	 
//	            public void prepare(MimeMessage mimeMessage) throws Exception {
//	                mimeMessage.setFrom("gestibanktest@gmail.com");
//	                mimeMessage.setRecipient(Message.RecipientType.TO,
//	                        new InternetAddress(notif.getInfoClient().getEmail()));
//	                        		
//	                mimeMessage.setText("CHER " +notif.getInfoClient().getNom()
//	                        + ", MERCI POUR VOTRE FIDELITE  " + notif.getNotifId()+".");
//	                		
//	                mimeMessage.setSubject("VOTRE COMMANDE DE CHEQUIER");
//	            }
//	        };
//	        return preparator;
//	    }
	 
	 
	 //////////////////////////////
	 
	 private MimeMessagePreparator getContentWtihAttachementMessagePreparator(final Notification notif) {
		 
	        MimeMessagePreparator preparator = new MimeMessagePreparator() {
	 
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	 
	                helper.setSubject("Votre demande chequier avec piece jointe ");
	                helper.setFrom("gestibanktest@gmail.com");
	              //  helper.setTo(notif.getInfoClient().getEmail());
	                		
	              /*  String content = "Cher " + notif.getInfoClient().getNom()
	                	
	                        + ", MERCI POUR VOTRE DEMANDE CHEQIER DEMANDE N°:" + notif.getNotifId()+".";
	                   */ 
	 
	 //               helper.setText(content);
	 
	                // Add a resource as an attachment
	                helper.addAttachment("cutie.png", new ClassPathResource("linux-icon.png"));
	 
	            }
	        };
	        return preparator;
	    }
	 
	 ///////////////////////////////////////////
	 
	 private MimeMessagePreparator getContentAsInlineResourceMessagePreparator(final Notification notif) {
		 
	        MimeMessagePreparator preparator = new MimeMessagePreparator() {
	 
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
	 
	                helper.setSubject("VOTRE DEMANDE DE CHEQUIER EN LIGNE :");
	                helper.setFrom("gestibanktest@gmail.com");
	              //  helper.setTo(notif.getInfoClient().getEmail());
	                /*		
	 
	                String content = "cher " + notif.getInfoClient().getNom()
	                		
	                        + ", MERCI POUR VOTRE DEMANDE CHEQUIER N°:" + notif.getNotifId()+".";
	                  */     
	 
	                // Add an inline resource.
	                // use the true flag to indicate you need a multipart message
	            //    helper.setText("<html><body><p>" + content + "</p><img src='cid:company-logo'></body></html>", true);
	                helper.addInline("company-logo", new ClassPathResource("linux-icon.png"));
	            }
	        };
	        return preparator;
	    }
	 

}
