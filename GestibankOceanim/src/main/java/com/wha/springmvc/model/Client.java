package com.wha.springmvc.model;

import java.util.Date;
import java.util.List;

public class Client extends User {
	
//-------------------------attributs--------------------------------------------
    
	private long id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
    private Date dateDemande;
	private Date dateCreaCompte;
	private List<Compte> comptes;
	
//-------------------------constructeurs----------------------------------------
    
	public Client(){
		
		id=0;
}
    public Client(long id, String nom, String prenom, String email, String addresse, Date dateDemande, Date dateCreaCompte){
		
		this.id=id;
		this.nom="nom";
		this.prenom="prenom";
		this.email="email";
		this.adresse="adresse";
		this.dateDemande=dateDemande;
		this.dateCreaCompte=dateCreaCompte;
		this.comptes=comptes;
}

//------------------------------------méthodes---------------------------------------------
    
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Date getDateDemande() {
		return dateDemande;
	}
	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}
	public Date getDateCreaCompte() {
		return dateCreaCompte;
	}
	public void setDateCreaCompte(Date dateCreaCompte) {
		this.dateCreaCompte = dateCreaCompte;
	}
		
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateCreaCompte == null) ? 0 : dateCreaCompte.hashCode());
		result = prime * result + ((dateDemande == null) ? 0 : dateDemande.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Client other = (Client) obj;
		if (dateCreaCompte == null) {
			if (other.dateCreaCompte != null)
				return false;
		} else if (!dateCreaCompte.equals(other.dateCreaCompte))
			return false;
		if (dateDemande == null) {
			if (other.dateDemande != null)
				return false;
		} else if (!dateDemande.equals(other.dateDemande))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
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
		return "Client [getId()=" + getId() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getEmail()=" + getEmail() + ", getAdresse()=" + getAdresse() + ", getDateDemande()="
				+ getDateDemande() + ", getDateCreaCompte()=" + getDateCreaCompte() + "]";
	}
	

}
