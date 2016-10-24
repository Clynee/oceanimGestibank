package com.wha.springmvc.entities;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import com.wha.springmvc.enums.TypeNotification;

@Entity
@DiscriminatorValue("NODE")
public class NotificationDemande extends Notification {

	@OneToOne//(cascade = CascadeType.ALL)
	@JoinTable(name = "notif_demande", 
	joinColumns = @JoinColumn(name = "notif_id", 
	referencedColumnName = "idNotification"), 
	inverseJoinColumns = @JoinColumn(name = "demande_id", 
	referencedColumnName = "ref"))
	private Demande demande;

	public NotificationDemande() {
		super();
		setType(TypeNotification.DEMANDE);
	}

	public NotificationDemande(String libelle) {
		super(libelle);
		setType(TypeNotification.DEMANDE);
	}

	public NotificationDemande(Demande demande) {
		super();
		setType(TypeNotification.DEMANDE);
		this.demande = demande;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

}
