package com.wha.springmvc.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan(basePackages = "com.wha.springmvc")
public class AppConfiguration {
	
	  @Bean
	    public JavaMailSender getMailSender(){
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	         
	        //Using gmail
	        mailSender.setHost("smtp.gmail.com");
	        mailSender.setPort(587);
	        mailSender.setUsername("gestibanktest@gmail.com");
	        mailSender.setPassword("gestibank");
	         
	        Properties javaMailProperties = new Properties();
	        
	        //javaMailProperties.put("mail.smtp.socketFactory.port", "465");
	       // javaMailProperties.put("mail.smtp.socketFactory.class",
	 	       //   "javax.net.ssl.SSLSocketFactory");
	       javaMailProperties.put("mail.smtp.starttls.enable", "true");
	        javaMailProperties.put("mail.smtp.auth", "true");
	        javaMailProperties.put("mail.transport.protocol", "smtp");
	        javaMailProperties.put("mail.debug", "true");//Prints out everything on screen
	         
	        mailSender.setJavaMailProperties(javaMailProperties);
	        return mailSender;
	    }

}
