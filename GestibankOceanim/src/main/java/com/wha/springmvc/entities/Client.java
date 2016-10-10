package com.wha.springmvc.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import com.wha.springmvc.constants.TypeRole;
/*
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Entity
@Table(name="CLIENTS")*/
public class Client extends User implements Serializable {
	/*@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODE_CLI")*/
	private Long codeClient ;
	private String nomClient;
	/*@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(
           name="adresse_client",
         referencedColumnName="idAdresse"
     )*/
	private Adresse adresseClient;
	
	/*@OneToMany(mappedBy="client",fetch=FetchType.LAZY)*/
	private Collection<Compte> comptes;
	
	
	
	/*@ManyToOne
	@JoinColumn(name="CODE_CONSEIL")*/
	private Conseiller conseiller;
	
    private Date dateCreation;
    private Date dateMiseAjour;



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







	public Client() {
		super();
		// TODO Auto-generated constructor stub
		setRoleUsers(TypeRole.CLIENT);
	}
	
	
	
	
	
	
	
	public Client(String nomClient, Adresse adresseClient) {
		super();
		this.nomClient = nomClient;
		this.adresseClient = adresseClient;
	}







	public Long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public Adresse getAdresseClient() {
		return adresseClient;
	}
	public void setAdresseClient(Adresse adresseClient) {
		this.adresseClient = adresseClient;
	}
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	

	
	
}
