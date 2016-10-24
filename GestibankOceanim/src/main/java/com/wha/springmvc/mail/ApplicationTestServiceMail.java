package com.wha.springmvc.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wha.springmvc.configuration.HelloWorldConfiguration;
import com.wha.springmvc.configuration.JpaConfiguration;
import com.wha.springmvc.entities.Adresse;
import com.wha.springmvc.entities.Client;
import com.wha.springmvc.entities.Notification;
import com.wha.springmvc.service.NotificationService;

@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from AppConfig and TestConfig
@WebAppConfiguration
@ContextConfiguration(classes = { HelloWorldConfiguration.class,JpaConfiguration.class })
//HelloWorldConfiguration.class, 
//@ContextConfiguration(classes = {SpringConfiguration.class })
public class ApplicationTestServiceMail {

	@Autowired
	private NotificationService notifService;

	@Test
	public void testAdditionner() {
		notifService.sendNotifConfirmation(getDummyOrder());
	}

	public static Notification getDummyOrder() {
		Notification notif = new Notification();
	//	notif.setNotifId("Demande chequier N°: 1111");
		
		
	
		
		//notif.setNotificationName("Demande Chéquier");

		
		//notif.setNotificationName("Demande chequier ");
	
		//notif.setStatus("confirmed");

		Client infoclient = new Client();
		infoclient.setNom("CELINE ");

		infoclient.setAddress(new Adresse(2, "jacke", 2365, "NANTES"));

		infoclient.setEmail("b.aissamedjkoune@gmail.com");

		//notif.setInfoClient(infoclient);

		return notif;
	}

}
