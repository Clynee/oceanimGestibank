package com.wha.springmvc.entities;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.wha.springmvc.enums.EtatNotification;
import com.wha.springmvc.enums.TypeNotification;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_NOTIF",discriminatorType=DiscriminatorType.STRING,length=10)

public class Notification {
	@Id
	@GeneratedValue
	private Long idNotification;
	private Date dateNotification; 
	private String libelle;
	private EtatNotification etat;
	private TypeNotification type;
	
	/*@OneToOne//(cascade = CascadeType.ALL)
	@JoinTable(name = "notif_destinateur", 
	joinColumns = @JoinColumn(name = "notif_id", 
	referencedColumnName = "idNotification"), 
	inverseJoinColumns = @JoinColumn(name = "destinateur_id", 
	referencedColumnName = "id"))
	*/
	@ManyToOne
	@JoinColumn(name="destinateur")
	private User destinateur;
	
	public Notification() {
		super();
		this.etat = EtatNotification.NONLUE;
		this.dateNotification = new Date();
	}
	public Notification(String libelle) {
		this();
		this.libelle = libelle;
	}
	
	
	
	public TypeNotification getType() {
		return type;
	}
	public void setType(TypeNotification type) {
		this.type = type;
	}
	public User getDestinateur() {
		return destinateur;
	}
	public void setDestinateur(User destinateur) {
		this.destinateur = destinateur;
	}
	public Long getIdNotification() {
		return idNotification;
	}
	public void setIdNotification(Long idNotification) {
		this.idNotification = idNotification;
	}
	public Date getDateNotification() {
		return dateNotification;
	}
	public void setDateNotification(Date dateNotification) {
		this.dateNotification = dateNotification;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public EtatNotification getEtat() {
		return etat;
	}
	public void setEtat(EtatNotification etat) {
		this.etat = etat;
	}
	
	
	
	
	

//	   private String notifId;
//     
//	    private String notificationName;
//	 
//	    private String status;
//	     
//	    private Client InfoClient;
//
//		public String getNotifId() {
//			return notifId;
//		}
//
//		public void setNotifId(String notifId) {
//			this.notifId = notifId;
//		}
//
//		public String getNotificationName() {
//			return notificationName;
//		}
//
//		public void setNotificationName(String notificationName) {
//			this.notificationName = notificationName;
//		}
//
//		public String getStatus() {
//			return status;
//		}
//
//		public void setStatus(String status) {
//			this.status = status;
//		}
//
//		public Client getInfoClient() {
//			return InfoClient;
//		}
//
//		public void setInfoClient(Client infoClient) {
//			InfoClient = infoClient;
//		}

		
	    
	    
	    
}
