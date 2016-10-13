package com.wha.springmvc.entities;


import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("V")
public class Credit extends Transaction {

	public Credit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Credit(Date dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Versement";
	}
	
	
	

}
