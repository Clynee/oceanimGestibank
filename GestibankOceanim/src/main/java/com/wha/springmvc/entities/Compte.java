package com.wha.springmvc.entities;



import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2)
public class Compte implements Serializable {

	@Id
	private String codeCompte;
	private Date dateCreation;
	private double solde;
	private Date dateMiseAjour;
	private double decouvert;
	
	@ManyToOne
	@JoinColumn(name="codeClient")
	private Client client;
	
	@JsonIgnore
	@OneToMany(mappedBy="compte")
	private Collection<Transaction> operations;
	
	@JsonIgnore
	@OneToMany(mappedBy="compte")
	private List<DemandeModifications> demandesModifs;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="compte")
	private List<DemandeChequier> demandesChequiers;
	
	
	public Compte() {
		super();
		this.dateCreation = new Date((new java.util.Date()).getTime());
	}
	
	public Compte(String codeCompte, double solde,double decouvert) {
		this();
		this.codeCompte = codeCompte;
		this.solde = solde;
		this.decouvert = decouvert;
	}
	
	
	
	
	public List<DemandeModifications> getDemandesModifs() {
		return demandesModifs;
	}

	public void setDemandesModifs(List<DemandeModifications> demandesModifs) {
		this.demandesModifs = demandesModifs;
	}

	public List<DemandeChequier> getDemandesChequiers() {
		return demandesChequiers;
	}

	public void setDemandesChequiers(List<DemandeChequier> demandesChequiers) {
		this.demandesChequiers = demandesChequiers;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public Date getDateMiseAjour() {
		return dateMiseAjour;
	}



	public void setDateMiseAjour(Date dateMiseAjour) {
		this.dateMiseAjour = dateMiseAjour;
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

	public Collection<Transaction> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Transaction> operations) {
		this.operations = operations;
	}

	
	
	
	
}
