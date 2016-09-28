package com.wha.springmvc.model;

import java.util.Date;

public class Compte {
	
//-------------------------attributs--------------------------------------------
	
	private int numCompte;
	private double solde;
	private int montantDecouvert;
	private Boolean etatCompte;
	private Date dateCreaCompte;
	private Client client;
//-------------------------constructeurs----------------------------------------
	
	public Compte(){
		
		numCompte=0;
	}
    public Compte(int numCompte, Date dateCreaCompte, Client client){
		
		this.numCompte=numCompte;
		this.solde=0;
		this.dateCreaCompte=dateCreaCompte;
		this.client=client;
	}
    
	
	
    public Compte(int numCompte, double solde, int montantDecouvert, Boolean etatCompte, Date dateCreaCompte){
		
		this.numCompte=numCompte;
		this.solde=solde;
		this.montantDecouvert=montantDecouvert;
		this.etatCompte=etatCompte;
		this.dateCreaCompte=dateCreaCompte;
	}
    
  //------------------------------------méthodes---------------------------------------------
    
	public int getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public int getMontantDecouvert() {
		return montantDecouvert;
	}
	public void setMontantDecouvert(int montantDecouvert) {
		this.montantDecouvert = montantDecouvert;
	}
	public Boolean getEtatCompte() {
		return etatCompte;
	}
	public void setEtatCompte(Boolean etatCompte) {
		this.etatCompte = etatCompte;
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
		int result = 1;
		result = prime * result + ((dateCreaCompte == null) ? 0 : dateCreaCompte.hashCode());
		result = prime * result + ((etatCompte == null) ? 0 : etatCompte.hashCode());
		result = prime * result + (int) (numCompte ^ (numCompte >>> 32));
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
		Compte other = (Compte) obj;
		if (dateCreaCompte == null) {
			if (other.dateCreaCompte != null)
				return false;
		} else if (!dateCreaCompte.equals(other.dateCreaCompte))
			return false;
		if (etatCompte == null) {
			if (other.etatCompte != null)
				return false;
		} else if (!etatCompte.equals(other.etatCompte))
			return false;
		if (numCompte != other.numCompte)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Compte [getNumCompte()=" + getNumCompte() + ", getSolde()=" + getSolde() + ", getMontantDecouvert()="
				+ getMontantDecouvert() + ", getEtatCompte()=" + getEtatCompte() + ", getDateCreaCompte()="
				+ getDateCreaCompte() + ", hashCode()=" + hashCode() + "]";
	}
    

}
