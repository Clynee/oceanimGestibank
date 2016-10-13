package com.wha.springmvc.entities;


import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.NotEmpty;

public class BanqueForm {
	@NotEmpty
	@Size(min=3,max=10)
	private String code;
	private Compte compte;
	private String typeCompte;
	private String exception;
	private List<Transaction> operations ;
	private String  typeOperation;
	@DecimalMin(value="50")
	private double montant=50;
	@NotEmpty
	@Size(min=3,max=10)
	private String code2="XXX";
	private String action;
	
	
	
	
	
	
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	public String getTypeOperation() {
		return typeOperation;
	}
	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}
	public List<Transaction> getOperations() {
		return operations;
	}
	public void setOperations(List<Transaction> operations) {
		this.operations = operations;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte cp) {
		this.compte = cp;
	}
	

}
