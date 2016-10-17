package com.wha.springmvc.entities;





import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("CC")

public class CompteCourant extends Compte {
	
	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(String codeCompte, double solde, double decouvert) {
		super(codeCompte, solde,decouvert);
	}

}
