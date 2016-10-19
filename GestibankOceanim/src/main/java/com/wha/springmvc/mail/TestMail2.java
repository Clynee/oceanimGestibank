package com.wha.springmvc.mail;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wha.springmvc.configuration.AppConfiguration;
import com.wha.springmvc.configuration.HelloWorldConfiguration;
import com.wha.springmvc.configuration.JpaConfiguration;
import com.wha.springmvc.entities.Adresse;
import com.wha.springmvc.entities.Client;
import com.wha.springmvc.entities.Notification;
import com.wha.springmvc.service.NotificationService;
@WebAppConfiguration
@ContextConfiguration(classes = { HelloWorldConfiguration.class, JpaConfiguration.class })

public class TestMail2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

		NotificationService orderService = (NotificationService) context.getBean("servicenotif");
		orderService.sendNotifConfirmation(getDummyOrder());
		((AbstractApplicationContext) context).close();
		
		
		
		
	
	}
	
	public static Notification getDummyOrder() {
		Notification notif = new Notification();
		notif.setNotificationName("1235");

		
		notif.setNotificationName("Demande chequier ");
	
		notif.setStatus("confirmed");

		Client infoclient = new Client();
		infoclient.setNom("aissa");

		infoclient.setAddress(new Adresse(2, "jacke", 2365, "NANTES"));

		infoclient.setEmail("b.aissamedjkoune@gmail.com");

		notif.setInfoClient(infoclient);

		return notif;
	}


}
