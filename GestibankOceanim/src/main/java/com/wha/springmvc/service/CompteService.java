package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.Transaction;

public interface CompteService {
	
    Compte creerCompte(Client client);
    Compte ajouterCompte(double montant, String typeCompte);
	List<Transaction> consulteCompte(int numCompte);
	
	
	Compte findCompte(int numCompte);
	List<Compte> findAllCompte(String nomClient); 
	List<Compte> findComptesByIdClient(int idClient);
	 	
	
	void updateTypeCompte(String typeCompte);
	void updateDecouvertCompte(int decouvert);
	
	
	void deleteCompte(int numCompte);
	void deleteAllCompte(String nomClient);
	void deleteComptesByIdClient(int idClient); 
	

}
