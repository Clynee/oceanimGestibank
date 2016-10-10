package com.wha.springmvc.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import com.wha.springmvc.constants.TypeRole;

/*import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Entity*/
public class Conseiller extends User implements Serializable {
	/*@Id
	@GeneratedValue
	@Column(name="CODE_CONSEIL")*/
	private Long codeConseiller;
	private String nomConseiller;
	private double salaire;
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







	/*@ManyToOne
	@JoinColumn(name="CODE_EMP_SUP")*/
	private Conseiller employeSup;
	/*
	@ManyToMany
	@JoinTable(name="EMP_GR",joinColumns =
	@JoinColumn(name = "CODE_CONSEIL"),
	inverseJoinColumns = @JoinColumn(name = "CODE_GROUPE"))
	*/
	/*@Transient
	
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(
           name="adresse_client",
         referencedColumnName="idAdresse"
     )
	*/
	private Adresse adresse;
	/*
	@OneToMany
	@JoinTable(name="Conseil_Client",joinColumns =
	@JoinColumn(name = "CODE_CONSEIL"),
	inverseJoinColumns = @JoinColumn(name = "CODE_CLI"))
	*/
   // @OneToMany(mappedBy="conseiller",fetch=FetchType.LAZY)
	private Collection<Client> clients;
		

	
	public Conseiller() {
		super();
		// TODO Auto-generated constructor stub
		setRoleUsers(TypeRole.CONSEILLER);
	}



public Conseiller(String nomConseiller) {
	super();
	this.nomConseiller=nomConseiller;
}



public Long getCodeConseiller() {
	return codeConseiller;
}



public void setCodeConseiller(Long codeConseiller) {
	this.codeConseiller = codeConseiller;
}



public String getNomConseiller() {
	return nomConseiller;
}



public void setNomConseiller(String nomConseiller) {
	this.nomConseiller = nomConseiller;
}



public double getSalaire() {
	return salaire;
}



public void setSalaire(double salaire) {
	this.salaire = salaire;
}



public Conseiller getEmployeSup() {
	return employeSup;
}



public void setEmployeSup(Conseiller employeSup) {
	this.employeSup = employeSup;
}



public Adresse getAdresse() {
	return adresse;
}



public void setAdresse(Adresse adresse) {
	this.adresse = adresse;
}



public Collection<Client> getClients() {
	return clients;
}



public void setClients(Collection<Client> clients) {
	this.clients = clients;
}


	
	
	

}
