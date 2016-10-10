package com.wha.springmvc.entities;

import java.util.Date;
/*
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("R")*/
public class Debit extends Transaction {

	public Debit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Debit(Date dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Retrait";
	}
	
}
