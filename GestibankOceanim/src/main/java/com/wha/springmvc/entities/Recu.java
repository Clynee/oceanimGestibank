package com.wha.springmvc.entities;


import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.wha.springmvc.enums.TypeTransaction;
@Entity
@DiscriminatorValue("RECU")
public class Recu extends Transaction {

	public Recu() {
		super();
		setTypeTransaction(TypeTransaction.RECU);
		setLibelle("Virement de :");
	}

	public Recu(double montant) {
		super(montant);
		setTypeTransaction(TypeTransaction.RECU);
		setLibelle("Virement de :");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Versement";
	}

	
	
	
	
	

}
