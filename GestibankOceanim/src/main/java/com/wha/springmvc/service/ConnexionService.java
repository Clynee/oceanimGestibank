package com.wha.springmvc.service;


import com.wha.springmvc.model.User;

public interface ConnexionService {
	public User seConnecter(String identifiant, String motDePasse);
}
