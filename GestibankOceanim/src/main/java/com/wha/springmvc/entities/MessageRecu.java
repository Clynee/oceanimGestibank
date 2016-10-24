package com.wha.springmvc.entities;

import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.wha.springmvc.enums.TypeMessge;
@Entity
@DiscriminatorValue("RECU")
public class MessageRecu extends Message {

	public MessageRecu() {
		super();
		this.setTypeMessage(TypeMessge.RECU);
	}

	public MessageRecu(Date date, String libelle, User concerne, TypeMessge typeMessage) {
		super(date, libelle, concerne, typeMessage);
		this.setTypeMessage(TypeMessge.RECU);
	}
	
}
