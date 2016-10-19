package com.wha.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.entities.Notification;
@Service("servicenotif")
public class NotificationServiceImpl implements NotificationService {


    @Autowired
    MailService mailService;
	@Override
	public void sendNotifConfirmation(Notification notification) {
		// TODO Auto-generated method stub
		
		 mailService.sendEmail(notification);
	}

}
