package com.wha.springmvc.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.wha.springmvc.enums.TypeCompte;
import com.wha.springmvc.enums.TypeDemande;

@Entity
@DiscriminatorValue("COMP")
public class DemandeOuvertureCompte extends Demande {
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client client;
	private TypeCompte typeCompte;
	private boolean avecDecouvert;
	
	public DemandeOuvertureCompte() {
		super();
		setType(TypeDemande.NCOMPTE);
	}
	public DemandeOuvertureCompte(int num, User utilisateur) {
		super(num, utilisateur);
		setType(TypeDemande.NCOMPTE);
	}
	public TypeCompte getTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}
	public boolean isAvecDecouvert() {
		return avecDecouvert;
	}
	public void setAvecDecouvert(boolean avecDecouvert) {
		this.avecDecouvert = avecDecouvert;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
