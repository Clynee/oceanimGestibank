package com.wha.springmvc.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP",discriminatorType=DiscriminatorType.STRING,length=2)

public class Transaction implements Serializable {
	
	@Id
	@GeneratedValue
	private Long numeroOperation;
	private Date dateOperation;
	private double montant;
	@ManyToOne
	@JoinColumn(name="CODE_CPTE")
	private Compte compte;
	@ManyToOne
	@JoinColumn(name="CODE_EMP")
	private Conseiller employe;
	
	
	
	
	
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	public Transaction(Date dateOperation, double montant) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
	}







	public Long getNumeroOperation() {
		return numeroOperation;
	}
	public void setNumeroOperation(Long numeroOperation) {
		this.numeroOperation = numeroOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Conseiller getEmploye() {
		return employe;
	}
	public void setEmploye(Conseiller employe) {
		this.employe = employe;
	}
	
	

}