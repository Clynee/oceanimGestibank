package com.wha.springmvc.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.entities.Admin;
import com.wha.springmvc.entities.Client;
import com.wha.springmvc.entities.Conseiller;
import com.wha.springmvc.entities.User;



@Service
public class ConnexionServiceImp implements ConnexionService {
	@Autowired
    IBanqueService banqueService;
	
	@Override
	public User seConnecter(String identifiant, String motDePasse) {
		User user = null;
		List<User> users = banqueService.findAllUsers();
		
		for(User u : users){
			if(identifiant.equals(u.getUsername())&&motDePasse.equals(u.getPassword())){
				user = u;
				System.out.println("bien crée!!!!");
			}
		}
		return user;
	}

}
