package com.wha.springmvc.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wha.springmvc.constants.TypeRole;

@Entity
@DiscriminatorValue("CO")
public class Conseiller extends User implements Serializable {
	//@Id
	//@GeneratedValue
	@Column(name = "CODE_CONSEIL")
	private Long codeConseiller;
	private double salaire;
	private Date dateCreation;
	private Date dateMiseAjour;


	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conseiller")
	private Collection<Client> clients;

	public Conseiller() {
		super();
		setRoleUsers(TypeRole.CONSEILLER);
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
	public Long getCodeConseiller() {
		return codeConseiller;
	}

	public void setCodeConseiller(Long codeConseiller) {
		this.codeConseiller = codeConseiller;
	}



	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

}
