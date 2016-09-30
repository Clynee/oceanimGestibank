package com.wha.springmvc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.Transaction;
import com.wha.springmvc.model.User;



public class CompteServiceImpl implements CompteService {
	
	
	private static List<Compte> comptes;
	
	static{
		comptes= populateDummyComptes();
	}

	public Compte creerCompte(Client client) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Compte ajouterCompte(double montant, String typeCompte){
	
	    return null;   
	}
	
	public List<Transaction> consulteCompte(int numCompte) {
		for(Compte compte : comptes){
			if(compte.getNumCompte() == numCompte){
				return  compte.getHistorique();
			}
		}
		return null;
	}

	
	public Compte findCompte(int numCompte) {
		for(Compte compte : comptes){
			if(compte.getNumCompte() == numCompte){
				return  compte;
			}
		}
		return null;
	}

	
	public List<Compte> findComptesByIdClient(int idClient) {
		
		return null;
	}
	
     public List<Compte> findAllCompte(String nomClient) {
		
		return null;
	}

	
	public void updateTypeCompte(String typeCompte) {
		
		
	}

	
	public void updateDecouvertCompte(int decouvert) {
		
		
	}

	
	public void deleteCompte(int numCompte) {
		for (Iterator<Compte> iterator = comptes.iterator(); iterator.hasNext(); ) {
		    Compte compte = iterator.next();
		    if (compte.getNumCompte() == numCompte) {
		        iterator.remove();
		    }
		}	
	}

	
	public void deleteAllCompte(String nomClient) {
		for (Iterator<Compte> iterator = comptes.iterator(); iterator.hasNext(); ) {
		    Compte compte = iterator.next();
		    if (compte.getClient().getNom() == nomClient) {
		        iterator.remove();
		    }
		}		
	}

	
	public void deleteComptesByIdClient(int idClient) {
		
		for (Iterator<Compte> iterator = comptes.iterator(); iterator.hasNext(); ) {
		    Compte compte = iterator.next();
		    if (compte.getClient().getId() == idClient) {
		        iterator.remove();
		    }
		}
				
	}

	
	
	private static List<Compte> populateDummyComptes(){
		List<Compte> comptes = new ArrayList<Compte>();
		comptes.add(new Compte(333,11005.30,5000, "Compte remunere"));
		comptes.add(new Compte(444,32001.85,5000, "Compte remunere"));
		comptes.add(new Compte(555,1002.13,500, "Compte courant"));
		comptes.add(new Compte(666,7014.27,1000, "Compte courant"));
		return comptes;
	}


	
	

}
