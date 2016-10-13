package com.wha.springmvc.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.entities.Admin;
import com.wha.springmvc.entities.Client;
import com.wha.springmvc.entities.Conseiller;
import com.wha.springmvc.entities.User;



@Service("connexionService")
public class ConnexionServiceImp implements ConnexionService {
	@Autowired
    IBanqueService banqueService;
	@Override
	public User seConnecter(String identifiant, String motDePasse) {
		User user = null;
		List<User> users = banqueService.findAllUsers();
				
		/*
		User ad = new Admin();
		ad.setUsername("admin");
		ad.setPassword("1111");
		
		users.add(0, ad);
		
		User cn = new Conseiller();
		cn.setUsername("cons");
		cn.setPassword("1111");
		users.add(1,cn);
		
		User cl = new Client();
		cl.setUsername("cli");
		cl.setPassword("1111");
		users.add(2,cl);
		*/
		for(User u : users){
			if(u.getUsername().equals(identifiant)&&u.getPassword().equals(motDePasse)){
				user = u;
				System.out.println("bien crée!!!!");
			}
		}
		/*
		if("lemine".equals(identifiant)&&"1111".equals(motDePasse)){
			
			user = new User();
			user.setUsername(identifiant);
			user.setPassword(motDePasse);
			user.setId(123);
			user.setEmail("aa@bbbbb.com");
			System.out.println("bien crée!!!!");
		}
		
		*/
		return user;
	}

}
