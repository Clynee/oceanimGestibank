package com.wha.springmvc.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.wha.springmvc.enums.TypeDemande;

@Entity
@DiscriminatorValue("CHEQ")
public class DemandeChequier extends Demande {
	
	@ManyToOne
	@JoinColumn(name = "ID_COMPTE")
	private Compte compte;

	public DemandeChequier() {
		super();
		setType(TypeDemande.CHEQUIER);
	}

	public DemandeChequier(int num, User utilisateur) {
		super(num, utilisateur);
		setType(TypeDemande.CHEQUIER);
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
}
