package com.wha.springmvc.entities;

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

import com.wha.springmvc.enums.EtatDemande;
import com.wha.springmvc.enums.TypeDemande;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeDemande", discriminatorType = DiscriminatorType.STRING, length = 4)
public class Demande {

	// -------------------------attributs--------------------------------------------

	@Id
	@GeneratedValue
	private int ref;

	private Date dateDemande;
	private String message;
	private EtatDemande etatDemande;
	private TypeDemande type;

	@ManyToOne
	@JoinColumn(name = "CODE_USER")
	private User Exp;

	// -------------------------constructeurs----------------------------------------

	public Demande() {
		super();
		this.etatDemande = EtatDemande.EnCours;
		this.dateDemande = new Date();
	}


	public Demande(int num, User utilisateur) {
		this();
		this.ref = num;
		this.Exp = utilisateur;

	}

	// ------------------------------------------méthodes-------------------------------------------------

	
	
	
	
	
	public int getRef() {
		return ref;
	}

	public TypeDemande getType() {
		return type;
	}


	public void setType(TypeDemande type) {
		this.type = type;
	}


	public EtatDemande getEtatDemande() {
//			switch(this.etatDemande){
//			case EnCours: 
//				return "En cours";
//			case EnAttente: 
//				return "En attente";
//			case Validee:
//				return "Validée";
//			}
//		return "";
		return this.etatDemande;
	}


	public void setEtatDemande(EtatDemande etatDemande) {
		this.etatDemande = etatDemande;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getExp() {
		return Exp;
	}

	public void setExp(User exp) {
		Exp = exp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Exp == null) ? 0 : Exp.hashCode());
		result = prime * result + ((dateDemande == null) ? 0 : dateDemande.hashCode());
		result = prime * result + ((etatDemande == null) ? 0 : etatDemande.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ref;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Demande other = (Demande) obj;
		if (Exp == null) {
			if (other.Exp != null)
				return false;
		} else if (!Exp.equals(other.Exp))
			return false;
		if (dateDemande == null) {
			if (other.dateDemande != null)
				return false;
		} else if (!dateDemande.equals(other.dateDemande))
			return false;
		if (etatDemande == null) {
			if (other.etatDemande != null)
				return false;
		} else if (!etatDemande.equals(other.etatDemande))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (ref != other.ref)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Demande [getRef()=" + getRef() + ", getDateDemande()=" + getDateDemande() + ", getMessage()=" + getMessage() + ", getExp()=" + getExp() + ", hashCode()="
				+ hashCode() + "]";
	}

}
