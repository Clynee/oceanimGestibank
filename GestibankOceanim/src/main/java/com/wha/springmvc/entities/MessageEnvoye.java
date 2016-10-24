package com.wha.springmvc.entities;

import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.wha.springmvc.enums.TypeMessge;

@Entity
@DiscriminatorValue("ENVO")
public class MessageEnvoye extends Message {

	public MessageEnvoye() {
		super();
		this.setTypeMessage(TypeMessge.ENVOYE);
		}

	public MessageEnvoye(Date date, String libelle, User concerne, TypeMessge typeMessage) {
		super(date, libelle, concerne, typeMessage);
		this.setTypeMessage(TypeMessge.ENVOYE);
	}

}
