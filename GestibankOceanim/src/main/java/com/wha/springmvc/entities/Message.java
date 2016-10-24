package com.wha.springmvc.entities;

import java.sql.Date;

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

import com.wha.springmvc.enums.TypeMessge;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_MESSAGE",discriminatorType=DiscriminatorType.STRING,length=4)

public class Message {
	@Id
	@GeneratedValue
	private Long idMessage;
	private Date date;
	private String libelle;
	private String contenu;
	
	/*@OneToOne//(cascade = CascadeType.ALL)
	@JoinTable(name = "message_user", 
	joinColumns = @JoinColumn(name = "message_id", 
	referencedColumnName = "idMessage"), 
	inverseJoinColumns = @JoinColumn(name = "user_id", 
	referencedColumnName = "id"))*/
	@ManyToOne
	@JoinColumn(name="concerne")
	private User concerne;
	private TypeMessge typeMessage;
	public Message() {
		super();
		this.date = new Date((new java.util.Date()).getTime());
	}
	public Message(Date date, String libelle, User concerne, TypeMessge typeMessage) {
		super();
		this.date = date;
		this.libelle = libelle;
		this.concerne = concerne;
		this.typeMessage = typeMessage;
	}
	
	
	
	
	
	
	
	public Long getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(Long idMessage) {
		this.idMessage = idMessage;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public User getConcerne() {
		return concerne;
	}
	public void setConcerne(User concerne) {
		this.concerne = concerne;
	}
	public TypeMessge getTypeMessage() {
		return typeMessage;
	}
	public void setTypeMessage(TypeMessge typeMessage) {
		this.typeMessage = typeMessage;
	}
	
	
}
