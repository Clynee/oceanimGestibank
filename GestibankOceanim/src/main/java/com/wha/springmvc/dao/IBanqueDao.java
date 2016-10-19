package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.entities.Client;
import com.wha.springmvc.entities.Compte;
import com.wha.springmvc.entities.Conseiller;
import com.wha.springmvc.entities.Document;
import com.wha.springmvc.entities.Transaction;
import com.wha.springmvc.entities.User;

public interface IBanqueDao {
	
	public List<User> findAllUsers();
	public User updateUser(User user);
	
	
	public void miseAjourClient(Client client);
	public void miseAjourCompte(Compte cpte);
	public void saveCompte(Compte cpte);
	public Client ajouterClient(Client c);
	public Conseiller ajouterConseiller(Conseiller e);
	public void affectConseillerToClient(Long idConseil,Long idCli);
	public Compte ajouterCompte(Compte c,Long numCli);
	public Transaction ajouterOperation(Transaction op,String numCpte);
	public Compte consulterCompte(String numCpte);
	public List<Transaction> consulterOperations(String codeCompte,int position,int nboperation);
	public Client consulterClient(Long codeClient);
	public List<Client> consulterClients(String motcle);
	public List<Compte> getComptesByClient(long codeCli);
	public List<Compte> getComptesByConseiller(long codeConseil);
	public List<Conseiller> getConseillers();
	public int getNombreOperation(String numCpte);
	public void supprimerClient(Client client);
	public List<Client> findAllClients();
	public Client findClientById(long clientId);
	public Conseiller findConseillerById(long conseillerId);
	public List<Conseiller> findConseillersByName(String conseillerName);
	public void supprimerConseiller(Conseiller conseiller);
	public void miseAjourConseiller(Conseiller conseiller);
	public  List<Client> findClientsByConseiller(long idConseiller);
	
	//USER DOCUMENT UPLOAD 
	
	  List<Document> findAllDoc();
    
      Document findDocById(int id);
    
      void saveDoc(Document document);
//     
      List<Document> findAllDocByUserId(long userId);
//     
      void deleteDocById(int id);

}
