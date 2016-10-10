package com.wha.springmvc.entities;

import java.util.Date;

/*import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CE")*/
public class CompteRemunere extends Compte {
	
	private double  taux ;

	public CompteRemunere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteRemunere(String codeCompte, Date dateCreation, double solde, double taux) {
		super(codeCompte, dateCreation, solde);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
	

}
