package com.wha.springmvc.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wha.springmvc.constants.TypeRole;

@Entity
@DiscriminatorValue("CL")
public class Client extends User implements Serializable  {
	// @Id
	// @GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long codeClient;
	private String situationMaritale;
	private int nbrEnfants;
	private Date dateCreation;
	private Date dateMiseAjour;
	
	@JsonIgnore
	@OneToMany(mappedBy="client") 
	private Collection<Compte> comptes;
	
	@JsonIgnore
	@OneToMany(mappedBy="destinateur")
	private List<Notification> notification;

	@ManyToOne
	@JoinColumn(name = "CODE_CONSEIL")
	private Conseiller conseiller;
	
	@JsonIgnore
	@OneToMany(mappedBy="concerne")
	private List<Message> messages; 
	
	@JsonIgnore
	@OneToMany(mappedBy="client")
	private List<DemandeOuvertureCompte> demandesOvertureComptes;
	
	
	public Client() {
		super();
		setRoleUsers(TypeRole.CLIENT);
		notification = new ArrayList<Notification>();
		messages = new ArrayList<Message>();
	}
	
	public Client(String nomClient, Adresse adresseClient) {
		this();
		super.setAddress(adresseClient); // adresseClient = adresseClient;
	}
	
	
	
	
	
	public List<DemandeOuvertureCompte> getDemandesOvertureComptes() {
		return demandesOvertureComptes;
	}

	public void setDemandesOvertureComptes(List<DemandeOuvertureCompte> demandesOvertureComptes) {
		this.demandesOvertureComptes = demandesOvertureComptes;
	}

	public List<Notification> getNotification() {
		return notification;
	}

	public void setNotification(List<Notification> notification) {
		this.notification = notification;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public String getSituationMaritale() {
		return situationMaritale;
	}

	public void setSituationMaritale(String situationMaritale) {
		this.situationMaritale = situationMaritale;
	}

	public int getNbrEnfants() {
		return nbrEnfants;
	}

	public void setNbrEnfants(int nbrEnfants) {
		this.nbrEnfants = nbrEnfants;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateMiseAjour() {
		return dateMiseAjour;
	}

	public void setDateMiseAjour(Date dateMiseAjour) {
		this.dateMiseAjour = dateMiseAjour;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}


	public Long getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

}
