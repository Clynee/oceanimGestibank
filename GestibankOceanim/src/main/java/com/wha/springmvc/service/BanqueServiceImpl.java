package com.wha.springmvc.service;


import java.util.Date;
import java.util.List;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//annotation Transactional : dans la couche dao ont a pas gerer les transaction alors pour faire ca on demande a spring de gerer les transaction 
//en ajoutant l'annootation transactional dans BanquemetierImp le faite d ajouter transactional 
//ca veut dire vous etes entrain de dire a spring toutes les methodes sont transactional 
//ca veut dire quoi ca veut dire : 
// a chaque fois j appelle une methode de la couche metier spring va ouvrir une transaction 
//il execute la methode ,si la methode genere une exception il fait un rollback
//sinon il fait un commit ,c a dire ont a delegeur la gestion des transaction a spring 
//et ca grace a la dependence que ont a ajouter ds le fichier pom.xml:spring-tx

import com.wha.springmvc.dao.IBanqueDao;
import com.wha.springmvc.entities.Client;
import com.wha.springmvc.entities.Compte;
import com.wha.springmvc.entities.Conseiller;
import com.wha.springmvc.entities.Emis;
import com.wha.springmvc.entities.Recu;
import com.wha.springmvc.entities.Transaction;
import com.wha.springmvc.entities.User;

@Service("banqueService")
@Transactional
public class BanqueServiceImpl implements IBanqueService{
	
	@Autowired
	private IBanqueDao dao;
	
	
	public void setDao(IBanqueDao dao) {
		this.dao = dao;
	}
	
	//les methodes
	
	@Override
	
	public void supprimerClient(Client client){
		dao.supprimerClient(client);
	}
	
	@Override
	public void miseAjourClient(Client client){
		dao.miseAjourClient(client);
	}
	
	
	
	@Override
	public void miseAjourCompte(Compte cpte){
		dao.miseAjourCompte(cpte);
	}
	
	@Override
	public void saveCompte(Compte cpte){
		dao.saveCompte(cpte);
	}

	@Override
	public Client ajouterClient(Client c) {
		return dao.ajouterClient(c);
	}

	@Override
	public Conseiller ajouterConseiller(Conseiller e) {
		return dao.ajouterConseiller(e);
	}


	@Override
	public void affectConseillerToClient(Long idConseil,Long idCli) {
		// TODO Auto-generated method stub
		dao.affectConseillerToClient(idConseil, idCli);
	}

	@Override
	public Compte ajouterCompte(Compte c, Long numCli) {
		// TODO Auto-generated method stub
		return dao.ajouterCompte(c, numCli);
	}
	
	@Override
	public void crediter(double montant, String cpte) {
//		dao.ajouterOperation(new Recu(new Date(),montant), cpte);
//		Compte cp=dao.consulterCompte(cpte);
//		cp.setSolde(cp.getSolde()+montant);
	}

	@Override
	public void debiter(double montant, String cpte) {
//		dao.ajouterOperation(new Debit(new Date(),montant), cpte);
//		Compte cp=dao.consulterCompte(cpte);
//		cp.setSolde(cp.getSolde()-montant);
	}

	@Override
	@Transactional
	public void virement(double montant, String cpte1, String cpte2) {
		if((cpte2==null)||(cpte1==null)) {
			throw new RuntimeException("Compte Introuvable");
			}else{
			Emis opEmis = new Emis(montant); 
			opEmis.setLibelle(opEmis.getLibelle() + cpte2);
			Recu opRecu = new Recu(montant);
			opRecu.setLibelle(opRecu.getLibelle() + cpte1);
			dao.ajouterOperation(opEmis, cpte1);
			dao.ajouterOperation(opRecu, cpte2);
			//debiter(montant,cpte1);
			//crediter(montant,cpte2);
		}
	}

	@Override
	public Compte consulterCompte(String numCpte) {
		// TODO Auto-generated method stub
		return dao.consulterCompte(numCpte);
	}

	@Override
	public List<Transaction> consulterOperations(String codeCompte,int position,int nbOperation ) {
		return dao.consulterOperations(codeCompte,position,nbOperation);
	}

	@Override
	public Client consulterClient(Long codeClient) {
		// TODO Auto-generated method stub
		return dao.consulterClient(codeClient);
	}

	@Override
	public List<Client> consulterClients(String motcle) {
		// TODO Auto-generated method stub
		return dao.consulterClients(motcle);
	}

	@Override
	public List<Compte> getComptesByClient(long codeCli) {
		// TODO Auto-generated method stub
		return dao.getComptesByClient(codeCli);
	}

	@Override
	public List<Compte> getComptesByConseiller(long codeConseil) {
		// TODO Auto-generated method stub
		return dao.getComptesByConseiller(codeConseil);
	}


	@Override
	public List<Conseiller> getConseillers() {
		// TODO Auto-generated method stub
		return dao.getConseillers();
	}

	@Override
	public int getNombreOperation(String numCpte) {
		// TODO Auto-generated method stub
		return dao.getNombreOperation(numCpte);
	}

	@Override
	public List<Client> findAllClients() {
		// TODO Auto-generated method stub
		return dao.findAllClients();
	}

	@Override
	public Client findClientById(long clientId) {
		// TODO Auto-generated method stub
		return dao.findClientById(clientId);
	}

	@Override
	public Conseiller findConseillerById(long conseillerId) {
		// TODO Auto-generated method stub
		return dao.findConseillerById(conseillerId);
	}

	@Override
	public List<Conseiller> findConseillersByName(String conseillerName) {
		// TODO Auto-generated method stub
		return dao.findConseillersByName(conseillerName);
	}

	@Override
	public void supprimerConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		dao.supprimerConseiller(conseiller);
	}

	@Override
	public void miseAjourConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		
		dao.miseAjourConseiller(conseiller);
		
	}

	@Override
	public List<User> findAllUsers() {
		
		return dao.findAllUsers();
	}

	@Override
	public User updateUser(User user) {
		return dao.updateUser(user);
	}

	

	

}
