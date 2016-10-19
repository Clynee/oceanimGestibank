package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.entities.Client;
import com.wha.springmvc.entities.Compte;
import com.wha.springmvc.entities.Conseiller;
import com.wha.springmvc.entities.Document;
import com.wha.springmvc.entities.Transaction;
import com.wha.springmvc.entities.User;


public interface IBanqueService {
	
	
	/* Tous les users */
	public List<User> findAllUsers();
	public User updateUser(User user); 
	
	/*OPERATIONS CLIENTS */
	public List<Client> findAllClients();
	public void miseAjourClient(Client client);
	public Client ajouterClient(Client c);
	public void supprimerClient(Client client);
	public Client consulterClient(Long codeClient);
	public List<Client> consulterClients(String motcle);
	public List<Compte> getComptesByClient(long codeCli);
	public Client findClientById(long clientId);
	
	
	/*OPERATIONS COMPTES*/
	public void saveCompte(Compte cpte);
	public void miseAjourCompte(Compte cpte);
	public Compte ajouterCompte(Compte c,Long numCli);
	public Compte consulterCompte(String numCpte);
	public List<Transaction> consulterOperations(String codeCompte,int position,int nbOperation );
	
	/*OPERATIONS CONSEILLER*/
	public Conseiller ajouterConseiller(Conseiller e);
	public void affectConseillerToClient(Long idConseil,Long idCli);
	public List<Compte> getComptesByConseiller(long codeConseil);
	public List<Conseiller> getConseillers();
	public Conseiller findConseillerById(long conseillerId);
	public List<Conseiller> findConseillersByName(String conseillerName);
	public void supprimerConseiller(Conseiller conseiller);
	public void miseAjourConseiller(Conseiller conseiller);
	public List<Client> findClientsByConseiller (long idConseiller);
	
	/* OPEARTIONS TRANSACTIONS*/
	/**
	 * cette fonction permet de r�cuperer le nombre de transaction 
	 * @param numCpte le compte en question 
	 * @return 
	 */
	public int getNombreOperation(String numCpte);
	
	/**
	 * 
	 * @param montant
	 * @param cpte
	 * @param codeConseil
	 */
	public void crediter(double montant,String cpte);
	public void debiter(double montant,String cpte);
	public void virement(double montant,String cpte1,String cpte2);
	
	
	// Methodes Document Upload 
	
	  List<Document> findAllDoc();
	    
      Document findDocById(int id);
    
      void saveDoc(Document document);
    
      List<Document> findAllDocByUserId(long userId);
    
      void deleteDocById(int id);

	
	


}
