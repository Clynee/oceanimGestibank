package com.wha.springmvc.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.wha.springmvc.enums.TypeDemande;


@Entity
@DiscriminatorValue("MODI")
public class DemandeModifications extends Demande{
	@ManyToOne
	@JoinColumn(name = "ID_COMPTE")
	private Compte compte;
	private boolean modifDecouvert;
	private boolean typeCompte;
	private boolean remuneration;
	
	
	public DemandeModifications() {
		super();
		setType(TypeDemande.MODIF);
	}
	public DemandeModifications(int num, User utilisateur) {
		super(num, utilisateur);
		setType(TypeDemande.MODIF);
	}
	
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public boolean isModifDecouvert() {
		return modifDecouvert;
	}
	public void setModifDecouvert(boolean modifDecouvert) {
		this.modifDecouvert = modifDecouvert;
	}
	public boolean isTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(boolean typeCompte) {
		this.typeCompte = typeCompte;
	}
	public boolean isRemuneration() {
		return remuneration;
	}
	public void setRemuneration(boolean remuneration) {
		this.remuneration = remuneration;
	}
	
	
}
