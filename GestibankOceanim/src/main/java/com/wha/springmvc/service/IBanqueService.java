package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.entities.Client;
import com.wha.springmvc.entities.Compte;
import com.wha.springmvc.entities.Conseiller;
import com.wha.springmvc.entities.Transaction;


public interface IBanqueService {
	
	
	
	public void miseAjourClient(Client client);
	
	public void supprimerClient(Client client);
	
	public void saveCompte(Compte cpte);
	
	public void miseAjourCompte(Compte cpte);
	
	public Client ajouterClient(Client c);
	
	public Conseiller ajouterConseiller(Conseiller e,Long codeSup);
	
	public void affectConseillerToClient(Long idConseil,Long idCli);
	
	public Compte ajouterCompte(Compte c,Long numCli,Long numConseil );
	
	public void crediter(double montant,String cpte ,Long codeConseil );
	
	public void debiter(double montant,String cpte ,Long codeConseil );
	
	public void virement(double montant,String cpte1,String cpte2 ,Long codeConseil );
   
	public Compte consulterCompte(String numCpte);
	
	public List<Transaction> consulterOperations(String codeCompte,int position,int nbOperation );
	
	public Client consulterClient(Long codeClient);
	
	public List<Client> consulterClients(String motcle);
	
	public List<Compte> getComptesByClient(long codeCli);
	
	public List<Compte> getComptesByConseiller(long codeConseil);
	
	
	
	public List<Conseiller> getConseillers();
	
	
	
	public long getNombreOperation(String numCpte);
	
	
	//ajouter 
	

	public List<Client> findAllClients();
	public Client findClientById(long clientId);
	public Conseiller findConseillerById(long conseillerId);
	public List<Conseiller> findConseillersByName(String conseillerName);
	public void supprimerConseiller(Conseiller conseiller);
	public void miseAjourConseiller(Conseiller conseiller);

}
