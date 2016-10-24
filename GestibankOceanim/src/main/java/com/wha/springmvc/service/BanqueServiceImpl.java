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
import com.wha.springmvc.entities.Admin;
import com.wha.springmvc.entities.Client;
import com.wha.springmvc.entities.Compte;
import com.wha.springmvc.entities.Conseiller;
import com.wha.springmvc.entities.Demande;
import com.wha.springmvc.entities.DemandeChequier;
import com.wha.springmvc.entities.DemandeInscription;
import com.wha.springmvc.entities.Document;
import com.wha.springmvc.entities.Emis;
import com.wha.springmvc.entities.FicheInscription;
import com.wha.springmvc.entities.Message;
import com.wha.springmvc.entities.Notification;
import com.wha.springmvc.entities.NotificationDemande;
import com.wha.springmvc.entities.NotificationMessage;
import com.wha.springmvc.entities.NotificationTransaction;
import com.wha.springmvc.entities.Recu;
import com.wha.springmvc.entities.Transaction;
import com.wha.springmvc.entities.User;
import com.wha.springmvc.enums.EtatDemande;

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
	public void inscription(FicheInscription fiche) {
		
		DemandeInscription demande = new DemandeInscription();
		
		Admin admin = (Admin)dao.getUser(1L);
		demande.setExp(admin);
		demande.setMessage("Une nouvelle demande");
		demande.setDateDemande(new java.util.Date());
		demande.setFicheInsc(fiche);
		ajouterDemande(demande);
	}
	
	
	@Override
	public User ajouterUser(User user) {
		return dao.ajouterUser(user);
	}
	
	@Override
	public Demande affectDemandeToUser(Integer idDemande, Long idConseiller) {
		return dao.affectDemandeToUser(idDemande, idConseiller);
	}

	@Override
	public List<Demande> getDemandeByUser(long idUser) {
		return dao.getDemandeByUser(idUser);
	}
	
	@Override
	public Demande ajouterDemande(Demande demande) {
		return dao.ajouterDemande(demande);
	}
	
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
			Transaction tra = dao.ajouterOperation(opEmis, cpte1);
			if(tra!=null){
			dao.ajouterOperation(opRecu, cpte2);
			//debiter(montant,cpte1);
			//crediter(montant,cpte2);
			Compte c = consulterCompte(cpte2);
			Compte c1 = consulterCompte(cpte1);
			NotificationTransaction notif = new NotificationTransaction();
			notif.setLibelle("Vous avez reçu un virement de " + c1.getClient().getNom() + "  " +c1.getClient().getPrenom());
			notif.setTransaction(opRecu);
			notif.setDestinateur(c.getClient());
			ajouterNotification(notif);
			}
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
	public List<Client> findClientsByConseiller(long idConseiller) {
	return dao.findClientsByConseiller(idConseiller);
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

	@Override
	public List<Document> findAllDoc() {
		// TODO Auto-generated method stub
		return dao.findAllDoc();
	}

	@Override
	public Document findDocById(int id) {
		// TODO Auto-generated method stub
		return dao.findDocById(id);
	}

	@Override
	public void saveDoc(Document document) {
		// TODO Auto-generated method stub
		dao.saveDoc(document);
	}

	@Override
	public List<Document> findAllDocByUserId(long userId) {
		// TODO Auto-generated method stub
		return dao.findAllDocByUserId(userId);
	}

	@Override
	public void deleteDocById(int id) {
		// TODO Auto-generated method stub
		dao.deleteDocById(id);
	}

	@Override
	public List<Demande> getDemandesAffectes(long idUser) {
		
		return dao.getDemandesAffectes(idUser);
	}

	@Override
	public Notification ajouterNotification(Notification notif) {
		// TODO Auto-generated method stub
		return dao.ajouterNotification(notif);
	}

	@Override
	public Message ajouterMessage(Message message) {
		// TODO Auto-generated method stub
		return dao.ajouterMessage(message);
	}

	@Override
	public List<Notification> getNotificationsByDestinateur(long idUser) {
		// TODO Auto-generated method stub
		return dao.getNotificationsByDestinateur(idUser);
	}

	@Override
	public void commanderChequier(Compte compte) {
		Compte c = consulterCompte(compte.getCodeCompte());
		DemandeChequier demande = new DemandeChequier();
		demande.setCompte(c);
		Conseiller cons = dao.findConseillerById(c.getClient().getConseiller().getId());
		demande.setExp(cons);
		ajouterDemande(demande);
	}

	@Override
	public void confirmerDemande(Demande demande) {
		Demande d = findDemandeByRef(demande.getRef());
		d.setEtatDemande(EtatDemande.Validee);
		NotificationDemande notif = new NotificationDemande("Votre demande de "+ d.getType() + " a été validée");
		notif.setDemande(d);
		notif.setDestinateur(((DemandeChequier)d).getCompte().getClient());
		ajouterNotification(notif);
	}

	@Override
	public Demande findDemandeByRef(int ref) {
		return dao.findDemandeByRef(ref);
	}

	@Override
	public void envoyerMessage(Message message, User cli) {
		User u = findUserById(cli.getId());
		NotificationMessage notif = new NotificationMessage();
		message.setConcerne(u);
		ajouterMessage(message);
		notif.setMessage(message);
		notif.setLibelle("Message de votre conseiller");
		notif.setDestinateur(u);
		ajouterNotification(notif);
	}

	@Override
	public User findUserById(long id) {
		return dao.getUser(id);
	}

	@Override
	public void envoyerMessage(Message message) {
		User u = findUserById(message.getConcerne().getId());
		NotificationMessage notif = new NotificationMessage();
		
		message.setConcerne(u);
		ajouterMessage(message);
		notif.setMessage(message);
		notif.setLibelle("Message de votre conseiller");
		notif.setDestinateur(u);
		ajouterNotification(notif);
		
	}

	

	

}
