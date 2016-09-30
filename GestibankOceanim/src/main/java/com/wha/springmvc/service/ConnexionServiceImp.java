package com.wha.springmvc.service;

import org.springframework.stereotype.Service;

import com.wha.springmvc.model.Conseiller;

@Service("connexionService")
public class ConnexionServiceImp implements ConnexionService {
	@Override
	public Conseiller seConnecter(String identifiant, String motDePasse) {
		Conseiller cons = null;
		if("lemine".equals(identifiant)&&"1111".equals(motDePasse)){
			cons = new Conseiller();
			cons.setNom(identifiant);
			cons.setPrenom(motDePasse);
		}
		return cons;
	}

}
