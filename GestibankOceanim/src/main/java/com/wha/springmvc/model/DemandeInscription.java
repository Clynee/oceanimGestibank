package com.wha.springmvc.model;

import java.util.Date;

public class DemandeInscription extends Demande {
	
	//-------------------------attributs--------------------------------------------
    
	
    private int  ref;
    private User user;
	private Date dateDemande;
	private FicheInscription fichInscr;
	
	
//-------------------------constructeurs----------------------------------------
    
	public DemandeInscription()
	{
		this.ref=0;
    }
	
    public DemandeInscription(int num, User utilisateur, Date date, FicheInscription fich)
    {			
		this.ref=num;
		this.user=utilisateur;
		this.dateDemande=date;
		this.fichInscr=fich;
		
    }
//------------------------------------------méthodes-------------------------------------------------

    

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public FicheInscription getFichInscr() {
		return fichInscr;
	}

	public void setFichInscr(FicheInscription fichInscr) {
		this.fichInscr = fichInscr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateDemande == null) ? 0 : dateDemande.hashCode());
		result = prime * result + ((fichInscr == null) ? 0 : fichInscr.hashCode());
		result = prime * result + ref;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (dateDemande == null) {
			if (other.dateDemande != null)
				return false;
		} else if (!dateDemande.equals(other.dateDemande))
			return false;
		if (fichInscr == null) {
			if (other.fichInscr != null)
				return false;
		} else if (!fichInscr.equals(other.fichInscr))
			return false;
		if (ref != other.ref)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DemandeInscription [getRef()=" + getRef() + ", getUser()=" + getUser() + ", getDateDemande()="
				+ getDateDemande() + ", getFichInscr()=" + getFichInscr() + ", hashCode()=" + hashCode() + "]";
	}
}
