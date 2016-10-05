package com.wha.springmvc.model;

import java.util.Date;
import java.util.List;

import com.wha.springmvc.model.User.Roles;

public class Client extends User {
	public static final Roles ROLE = Roles.client;
//-------------------------attributs--------------------------------------------
    
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
    private Date dateCreaCompte;
	private List<Compte> comptes;
	private List<Demande> demandes;
	
//-------------------------constructeurs----------------------------------------
    
	public Client(){
		
		id=0;
}
    public Client(int id, String nom, String prenom, String email, String addresse, Date dateCreaCompte){
		
		this.id=id;
		this.nom="nom";
		this.prenom="prenom";
		this.email="email";
		this.adresse="adresse";
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
	public void setId(int id) {
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
	public Date getDateCreaCompte() {
		return dateCreaCompte;
	}
	public void setDateCreaCompte(Date dateCreaCompte) {
		this.dateCreaCompte = dateCreaCompte;
	}
	public List<Demande> getDemandes() {
		return demandes;
	}
	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((comptes == null) ? 0 : comptes.hashCode());
		result = prime * result + ((dateCreaCompte == null) ? 0 : dateCreaCompte.hashCode());
		result = prime * result + ((demandes == null) ? 0 : demandes.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
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
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (comptes == null) {
			if (other.comptes != null)
				return false;
		} else if (!comptes.equals(other.comptes))
			return false;
		if (dateCreaCompte == null) {
			if (other.dateCreaCompte != null)
				return false;
		} else if (!dateCreaCompte.equals(other.dateCreaCompte))
			return false;
		if (demandes == null) {
			if (other.demandes != null)
				return false;
		} else if (!demandes.equals(other.demandes))
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
		return "Client [getComptes()=" + getComptes() + ", getId()=" + getId() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getEmail()=" + getEmail() + ", getAdresse()=" + getAdresse()
				+ ", getDateCreaCompte()=" + getDateCreaCompte() + ", getDemandes()=" + getDemandes() + ", hashCode()="
				+ hashCode() + "]";
	}

}
