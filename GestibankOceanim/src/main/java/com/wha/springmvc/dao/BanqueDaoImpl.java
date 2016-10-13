package com.wha.springmvc.dao;


import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.wha.springmvc.entities.Client;
import com.wha.springmvc.entities.Compte;
import com.wha.springmvc.entities.Conseiller;
import com.wha.springmvc.entities.Transaction;
import com.wha.springmvc.entities.User;

@Repository
public class BanqueDaoImpl implements IBanqueDao{
	@PersistenceContext
	private EntityManager em;
	
	
	
	
	
	//les methodes
	
	
	
	@Override
	public void miseAjourConseiller(Conseiller conseiller){
		
		if (conseiller != null) {
            conseiller.setDateMiseAjour(new Date((new java.util.Date()).getTime()));
            em.merge(conseiller);
        }
	}
	
	@Override
	public void supprimerConseiller(Conseiller conseiller){
		
		//Date d =new Date();
		 if (conseiller != null) {
	            conseiller.setDateMiseAjour(new Date((new java.util.Date()).getTime()));  
	            em.remove(em.merge(conseiller));
	        }
	}
	
	
	@Override	
	public List<Conseiller> findConseillersByName(String conseillerName){
		
		 Query q = em.createNamedQuery("conseiller.findConseillersByName");
         q.setParameter("Nom", "%" + conseillerName+ "%");
return (List<Conseiller>) q.getResultList();
	}
	
	@Override
	public Conseiller findConseillerById(long conseillerId){
		
		Query q = em.createNamedQuery("conseiller.findConseillerById");
        q.setParameter("id", conseillerId);
        
           return (Conseiller) q.getSingleResult();
	}
	
	@Override
	
	public Client findClientById(long clientId){
		 Query q = em.createNamedQuery("client.findClientById");
         q.setParameter("id", clientId);
   try {
   return  (Client)  q.getSingleResult();
      } catch (NoResultException nre) {
    return null;
    }
	}
	
	@Override
	
	public List<Client> findAllClients(){
		 Query q = em.createQuery("SELECT c FROM Client c "); 
		 /*em.createNamedQuery("client.findAllClients");*/
	        return (List<Client>) q.getResultList();
	}
	
	@Override
	public void supprimerClient(Client client){
		
		if (client != null)
            em.remove(em.merge(client));
	}
	
	
	
	
	@Override
	public void miseAjourClient(Client client){
		if (client != null){
			  client.setDateMiseAjour(new Date((new java.util.Date()).getTime()));
            em.merge(client);
		}
		
	}
	
	@Override
	public void miseAjourCompte(Compte cpte){
		
		if (cpte != null){
			   cpte.setDateMiseAjour(new Date((new java.util.Date()).getTime()));
            em.merge(cpte);
		}
	}
	
	@Override
	public void saveCompte(Compte cpte){
		if (cpte != null)
            em.persist(cpte);
	}

	@Override
	public Client ajouterClient(Client c) {
		// TODO Auto-generated method stub
		em.persist(c);
		return c;
	}

	@Override
	public Conseiller ajouterConseiller(Conseiller e) {
		/*
		if(codeSup!=null){
			Conseiller empSup=em.find(Conseiller.class, codeSup);
		e.setEmployeSup(empSup);
		}*/
		em.persist(e);
		return e;
	}
/*
	@Override
	public TestEntiteG addGroupe(TestEntiteG g) {
		em.persist(g);
		return g;
	}
*/
	@Override
	public void affectConseillerToClient(Long idConseil,Long idCli){
		Conseiller conseil=em.find(Conseiller.class, idConseil);
		Client c=em.find(Client.class, idCli);
		conseil.getClients().add(c);
		c.setConseiller(conseil);
		
		//getEmployes().add(conseil);
		//
		
	}

	@Override
	public Compte ajouterCompte(Compte c, Long numCli) {
		Client cli=em.find(Client.class, numCli);
		//Conseiller e=em.find(Conseiller.class,numEmp);
		c.setClient(cli);
		//c.setConseiller(e);
		em.persist(c);
		return c;
	}

	@Override
	public Transaction ajouterOperation(Transaction op,String numCpte,Long numConseil) {
		Compte c=em.find(Compte.class, numCpte);
		Conseiller conseil=em.find(Conseiller.class, numConseil);
		op.setEmploye(conseil);
		op.setCompte(c);
		em.persist(op);
		return op;
	}

	@Override
	public Compte consulterCompte(String numCpte) {
		Compte cpte=em.find(Compte.class, numCpte);
		if(cpte==null) throw new RuntimeException("Compte Introuvable");
		//cpte.getOperations().size();
		return cpte;
	}

	@Override
	public List<Transaction> consulterOperations(String codeCpte,int position,int nboperation) {
		Query req=em.createQuery("SELECT op FROM Transaction op WHERE op.compte.codeCompte=:x order by op.dateOperation desc");
				req.setParameter("x",codeCpte);
				req.setFirstResult(position);
				req.setMaxResults(nboperation);
				return req.getResultList();
	}

	@Override
	public Client consulterClient(Long codeClient) {
		Client c=em.find(Client.class, codeClient);
		if(c==null) throw new RuntimeException("Client INTROUVABLE");
		//cpte.getOperations().size();
		return c;
	}

	@Override
	public List<Client> consulterClients(String mc) {
		Query req=em.createQuery("select c from Client c where c.nomClient like=:x");
		req.setParameter("x","%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public List<Compte> getComptesByClient(long codeCli) {
		Query req=em.createQuery("select cp from Compte cp where cp.client.codeClient =:x");
		req.setParameter("x",codeCli);
		return req.getResultList();
	}

	@Override
	public List<Compte> getComptesByConseiller(long codeConseil){
		Query req=em.createQuery("select e from Compte e where e.conseiller.codeConseiller =:x");
		req.setParameter("x",codeConseil);
		return req.getResultList();
	}


	@Override
	public List<Conseiller> getConseillers() {
		Query req=em.createQuery("select e from Conseiller e  ");
		
		return req.getResultList();
	}


	@Override
	public long getNombreOperation(String numCpte) {
		Query req=em.createQuery("select count(o) from Transaction o where o.codeCompte=:x");
		req.setParameter("x", numCpte);
		return req.getFirstResult();
	}

	@Override
	public List<User> findAllUsers() {
		Query req = em.createQuery("select u from User u");
		return req.getResultList();
	}

}