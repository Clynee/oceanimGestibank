package com.wha.springmvc.entities;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.wha.springmvc.enums.TypeDemande;

@Entity
@DiscriminatorValue("INSC")
public class DemandeInscription extends Demande {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fiche_id")
	private FicheInscription ficheInsc;
	private String libelMessage;

	// -------------------------------------Constructeur---------------------------------------------------

	public DemandeInscription() {
		super();
		setType(TypeDemande.INSCRIPTION);
	}

	public DemandeInscription(FicheInscription ficheInsc, String libelMessage) {
		super();
		this.ficheInsc = ficheInsc;
		this.libelMessage = libelMessage;
		setType(TypeDemande.INSCRIPTION);
	}

	// ------------------------------les guetteurs et
	// setteurs------------------------------------------------
	public FicheInscription getFicheInsc() {
		return ficheInsc;
	}

	public void setFicheInsc(FicheInscription ficheInsc) {
		this.ficheInsc = ficheInsc;
	}

	public String getLibelMessage() {
		return libelMessage;
	}

	public void setLibelMessage(String libelMessage) {
		this.libelMessage = libelMessage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ficheInsc == null) ? 0 : ficheInsc.hashCode());
		result = prime * result + ((libelMessage == null) ? 0 : libelMessage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DemandeInscription other = (DemandeInscription) obj;
		if (ficheInsc == null) {
			if (other.ficheInsc != null)
				return false;
		} else if (!ficheInsc.equals(other.ficheInsc))
			return false;
		if (libelMessage == null) {
			if (other.libelMessage != null)
				return false;
		} else if (!libelMessage.equals(other.libelMessage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DemandeInscription [getFicheInsc()=" + getFicheInsc() + ", getMessage()=" + getMessage()
				+ ", getLibelMessage()=" + getLibelMessage() + ", hashCode()=" + hashCode() + "]";
	}

}
