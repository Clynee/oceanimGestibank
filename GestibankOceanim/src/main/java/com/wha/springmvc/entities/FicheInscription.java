package com.wha.springmvc.entities;



import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class FicheInscription {
	@Id
	@GeneratedValue
	private long idFiche;
	private double salaireMoyen;
	private String nom;
	private String prenom;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "fiche_addresse", joinColumns = @JoinColumn(name = "fiche_id", referencedColumnName = "idFiche"), inverseJoinColumns = @JoinColumn(name = "addresse_id", referencedColumnName = "idAdresse"))
	private Adresse adresse;
	private String email;
	private String typeCompte;
	private Date date;
	private String tel;
	private String situationMaritale;
	private int nbrEnfants;

	// -------------------------Constructeur--------------------------------------------------------------

	
	
	// -------------------------------------les guetteurs et les
	// ------------- Setteurs  --------------------------------------

	public FicheInscription() {
		super();
		this.date=new Date(new java.util.Date().getTime());
	}

	public FicheInscription(long idFiche, double salaireMoyen, String nom, String prenom, Adresse adresse, String email,
			String typeCompte, String tel, String situationMaritale, int nbrEnfants) {
		this();
		this.idFiche = idFiche;
		this.salaireMoyen = salaireMoyen;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.typeCompte = typeCompte;
		this.tel = tel;
		this.situationMaritale = situationMaritale;
		this.nbrEnfants = nbrEnfants;
	}

	public long getIdFiche() {
		return idFiche;
	}

	public void setIdFiche(long idFiche) {
		this.idFiche = idFiche;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public double getSalaireMoyen() {
		return salaireMoyen;
	}

	public void setSalaireMoyen(double salaireMoyen) {
		this.salaireMoyen = salaireMoyen;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	

	// ---------------------------------------Hash et
	// equal--------------------------------------------
	
	
	// ----------------------- to String --------------------------------------

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (idFiche ^ (idFiche >>> 32));
		result = prime * result + nbrEnfants;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salaireMoyen);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((situationMaritale == null) ? 0 : situationMaritale.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((typeCompte == null) ? 0 : typeCompte.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "FicheInscription [idFiche=" + idFiche + ", salaireMoyen=" + salaireMoyen + ", nom=" + nom + ", prenom="
				+ prenom + ", adresse=" + adresse + ", email=" + email + ", typeCompte=" + typeCompte + ", date=" + date
				+ ", tel=" + tel + ", situationMaritale=" + situationMaritale + ", nbrEnfants=" + nbrEnfants + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FicheInscription other = (FicheInscription) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idFiche != other.idFiche)
			return false;
		if (nbrEnfants != other.nbrEnfants)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (Double.doubleToLongBits(salaireMoyen) != Double.doubleToLongBits(other.salaireMoyen))
			return false;
		if (situationMaritale == null) {
			if (other.situationMaritale != null)
				return false;
		} else if (!situationMaritale.equals(other.situationMaritale))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (typeCompte == null) {
			if (other.typeCompte != null)
				return false;
		} else if (!typeCompte.equals(other.typeCompte))
			return false;
		return true;
	}

}
