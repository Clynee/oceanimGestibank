package com.wha.springmvc.service;

import com.wha.springmvc.model.Conseiller;

public interface ConnexionService {
	public Conseiller seConnecter(String identifiant, String motDePasse);

}
