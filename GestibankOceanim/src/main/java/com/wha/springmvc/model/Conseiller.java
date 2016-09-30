package com.wha.springmvc.model;

import java.util.Date;

public class Conseiller extends User {
	
//-------------------------attributs--------------------------------------------
    
	private long matricule;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
    private Date dateEntree;
	
//-------------------------constructeurs----------------------------------------
    
	public Conseiller(){
		
}
    public Conseiller(long matricule, String nom, String prenom, String email, String addresse, Date dateEntree){
		
		this.matricule=matricule;
		this.nom="nom";
		this.prenom="prenom";
		this.email="email";
		this.adresse="adresse";
		this.dateEntree=dateEntree;
}
    
//------------------------------------méthodes---------------------------------------------
    
	public long getMatricule() {
		return matricule;
	}
	public void setMatricule(long matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDateEntree() {
		return dateEntree;
	}
	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateEntree == null) ? 0 : dateEntree.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (matricule ^ (matricule >>> 32));
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Conseiller other = (Conseiller) obj;
		if (dateEntree == null) {
			if (other.dateEntree != null)
				return false;
		} else if (!dateEntree.equals(other.dateEntree))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (matricule != other.matricule)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Conseiller [getMatricule()=" + getMatricule() + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + ", getEmail()=" + getEmail() + ", getAdresse()=" + getAdresse() + ", getDateEntree()="
				+ getDateEntree() + "]";
	}
    
	

}
