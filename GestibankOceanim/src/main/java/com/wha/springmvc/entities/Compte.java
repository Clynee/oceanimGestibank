package com.wha.springmvc.entities;



import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2)
public class Compte implements Serializable {

	@Id
	private String codeCompte;
	private Date dateCreation;
	private double solde;
	@ManyToOne
	@JoinColumn(name="codeClient")
	private Client client;
	
	/*@ManyToOne
	@JoinColumn(name="CODE_CONSEIL")*/
	private Conseiller conseiller;
	@OneToMany(mappedBy="compte")
	private Collection<Transaction> operations;
	
	
	public Date getDateMiseAjour() {
		return dateMiseAjour;
	}



	public void setDateMiseAjour(Date dateMiseAjour) {
		this.dateMiseAjour = dateMiseAjour;
	}
	private Date dateMiseAjour;
	
	
	
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Compte(String codeCompte, Date dateCreation, double solde) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}



	public String getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Conseiller getConseiller() {
		return conseiller;
	}



	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}



	public Collection<Transaction> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Transaction> operations) {
		this.operations = operations;
	}
	
	
}
