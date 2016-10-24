package com.wha.springmvc.entities;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import com.wha.springmvc.enums.TypeNotification;

@Entity
@DiscriminatorValue("NOTR")
public class NotificationTransaction extends Notification {
	
	@OneToOne//(cascade = CascadeType.ALL)
	@JoinTable(name = "notif_transaction", 
	joinColumns = @JoinColumn(name = "notif_id", 
	referencedColumnName = "idNotification"), 
	inverseJoinColumns = @JoinColumn(name = "transaction_id", 
	referencedColumnName = "numeroOperation"))
	private Transaction transaction;
	
	
	public NotificationTransaction() {
		super();
		setType(TypeNotification.VIREMENT);
	}
	
	public NotificationTransaction(String libelle) {
		super(libelle);
		setType(TypeNotification.VIREMENT);
	}
	
	public NotificationTransaction(Transaction transaction) {
		super();
		setType(TypeNotification.VIREMENT);
		this.transaction = transaction;
	}
	
	
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
}
