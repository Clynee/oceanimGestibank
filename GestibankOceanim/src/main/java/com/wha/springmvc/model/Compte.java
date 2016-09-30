package com.wha.springmvc.model;

import java.util.Date;
import java.util.List;

public class Compte {
	
//-------------------------attributs--------------------------------------------
	
	private int numCompte;
	private double solde;
	private int montantDecouvert;
	private String typeCompte;
	private Date dateCreaCompte;
	private Client client;
	private List<Transaction> historique;
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
    
	
	
    public Compte(int numCompte, double solde, int montantDecouvert, String typeCompte){
		
		this.numCompte=numCompte;
		this.solde=solde;
		this.montantDecouvert=montantDecouvert;
		this.typeCompte=typeCompte;
		//this.dateCreaCompte=dateCreaCompte;
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
	
	
	public String getTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	public Date getDateCreaCompte() {
		return dateCreaCompte;
	}
	public void setDateCreaCompte(Date dateCreaCompte) {
		this.dateCreaCompte = dateCreaCompte;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Transaction> getHistorique() {
		return historique;
	}
	public void setHistorique(List<Transaction> historique) {
		this.historique = historique;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((dateCreaCompte == null) ? 0 : dateCreaCompte.hashCode());
		result = prime * result + ((historique == null) ? 0 : historique.hashCode());
		result = prime * result + montantDecouvert;
		result = prime * result + numCompte;
		long temp;
		temp = Double.doubleToLongBits(solde);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((typeCompte == null) ? 0 : typeCompte.hashCode());
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
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (dateCreaCompte == null) {
			if (other.dateCreaCompte != null)
				return false;
		} else if (!dateCreaCompte.equals(other.dateCreaCompte))
			return false;
		if (historique == null) {
			if (other.historique != null)
				return false;
		} else if (!historique.equals(other.historique))
			return false;
		if (montantDecouvert != other.montantDecouvert)
			return false;
		if (numCompte != other.numCompte)
			return false;
		if (Double.doubleToLongBits(solde) != Double.doubleToLongBits(other.solde))
			return false;
		if (typeCompte == null) {
			if (other.typeCompte != null)
				return false;
		} else if (!typeCompte.equals(other.typeCompte))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Compte [getNumCompte()=" + getNumCompte() + ", getSolde()=" + getSolde() + ", getMontantDecouvert()="
				+ getMontantDecouvert() + ", getTypeCompte()=" + getTypeCompte() + ", getDateCreaCompte()="
				+ getDateCreaCompte() + ", getClient()=" + getClient() + ", getHistorique()=" + getHistorique()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
