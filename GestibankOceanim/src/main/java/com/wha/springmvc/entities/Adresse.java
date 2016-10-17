package com.wha.springmvc.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Adresse {
	
	
	@Id
    @GeneratedValue
	private int idAdresse ;
	//@Column(name="nom_adresse")
	//private String nomAdresse;
	@Column(name="numero_rue")
	private int numDeRue;
	@Column(name="nom_rue")
	private String nomRue;
	@Column(name="code_postale")
	private int codePostale;
	@Column(name="nom_ville")
	private String ville;
	

	
	public Adresse(int numDeRue, String nomRue, int codePostale, String ville) {
		super();
		this.numDeRue = numDeRue;
		this.nomRue = nomRue;
		this.codePostale = codePostale;
		this.ville = ville;
	}

	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public int getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public int getNumDeRue() {
		return numDeRue;
	}

	public void setNumDeRue(int numDeRue) {
		this.numDeRue = numDeRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public int getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codePostale;
		result = prime * result + idAdresse;
		result = prime * result + ((nomRue == null) ? 0 : nomRue.hashCode());
		result = prime * result + numDeRue;
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		if (codePostale != other.codePostale)
			return false;
		if (idAdresse != other.idAdresse)
			return false;
		
		if (nomRue == null) {
			if (other.nomRue != null)
				return false;
		} else if (!nomRue.equals(other.nomRue))
			return false;
		if (numDeRue != other.numDeRue)
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", numDeRue=" + numDeRue + ", nomRue="
				+ nomRue + ", codePostale=" + codePostale + ", ville=" + ville + "]";
	}

	


}
