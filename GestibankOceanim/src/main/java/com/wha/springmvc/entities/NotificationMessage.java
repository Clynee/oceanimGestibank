package com.wha.springmvc.entities;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import com.wha.springmvc.enums.TypeNotification;

@Entity
@DiscriminatorValue("NOME")
public class NotificationMessage extends Notification {
	
		
	@OneToOne//(cascade = CascadeType.PERSIST)
	@JoinTable(name = "notif_message", 
	joinColumns = @JoinColumn(name = "notif_id", 
	referencedColumnName = "idNotification"), 
	inverseJoinColumns = @JoinColumn(name = "message_id", 
	referencedColumnName = "idMessage"))
	
		private Message message;
		
		public NotificationMessage() {
			super();
			setType(TypeNotification.MESSAGE);
		}
		public NotificationMessage(String libelle) {
			super(libelle);
			setType(TypeNotification.MESSAGE);
		}
		public NotificationMessage(Message message) {
			super();
			setType(TypeNotification.MESSAGE);
			this.message = message;			
		}
		public Message getMessage() {
			return message;
		}
		public void setMessage(Message message) {
			this.message = message;
		}
		
		
}
