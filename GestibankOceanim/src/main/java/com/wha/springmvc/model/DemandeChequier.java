package com.wha.springmvc.model;

import java.util.Date;

public class DemandeChequier extends DemandeClient {
	
//-------------------------attributs--------------------------------------------
    
	
    private int  ref;
    private Date dateDemande;
    
    private Client client;
    private Compte compte;
    
    private int tailleChequier;
	
	
//-------------------------constructeurs----------------------------------------
    
	public DemandeChequier()
	{
		this.ref=0;
    }
	
    public DemandeChequier(int num, Date date, Client client, Compte compte, int tailCheq)
    {			
		this.ref=num;
		this.dateDemande=date;
		this.client=client;
		this.compte=compte;	
		this.tailleChequier=tailCheq;
		
    }
    
  //------------------------------------------méthodes-------------------------------------------------

    public int getRef() {
		return ref;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public int getTailleChequier() {
		return tailleChequier;
	}

	public void setTailleChequier(int tailleChequier) {
		this.tailleChequier = tailleChequier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((compte == null) ? 0 : compte.hashCode());
		result = prime * result + ((dateDemande == null) ? 0 : dateDemande.hashCode());
		result = prime * result + ref;
		result = prime * result + tailleChequier;
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
		DemandeChequier other = (DemandeChequier) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (compte == null) {
			if (other.compte != null)
				return false;
		} else if (!compte.equals(other.compte))
			return false;
		if (dateDemande == null) {
			if (other.dateDemande != null)
				return false;
		} else if (!dateDemande.equals(other.dateDemande))
			return false;
		if (ref != other.ref)
			return false;
		if (tailleChequier != other.tailleChequier)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DemandeChequier [getRef()=" + getRef() + ", getDateDemande()=" + getDateDemande() + ", getClient()="
				+ getClient() + ", getCompte()=" + getCompte() + ", getTailleChequier()=" + getTailleChequier()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
}
