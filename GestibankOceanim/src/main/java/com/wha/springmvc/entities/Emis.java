package com.wha.springmvc.entities;


import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.wha.springmvc.enums.TypeTransaction;
@Entity
@DiscriminatorValue("EMIS")
public class Emis extends Transaction {

	public Emis() {
		super();
		setTypeTransaction(TypeTransaction.EMIS);
		setLibelle("Virement vers : ");
	}

	public Emis(double montant) {
		super(-montant);
		setTypeTransaction(TypeTransaction.EMIS);
		setLibelle("Virement vers : ");
	}

	@Override
	public String toString() {
		return "Retrait";
	}

	@Override
	public void setMontant(double montant) {
		// TODO Auto-generated method stub
		super.setMontant(-montant);
	}

	
	

	
}
