package com.wha.springmvc.model;


public class Admin extends User{
	public static final Roles ROLE = Roles.admin;
	
//----------------attributs------------------------------------------

	private int matricule;
	private String email;
	private String nom;
	
// ---------------constructeurs----------------------------------------
	
	public Admin(){
		
		this.matricule=34567;

}
	public Admin(String email){
		this.matricule =34567 ;
		this.nom = "Bigboss";
		this.email = email;
	}
	
//-------------------les méthodes----------------------------------------
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Admin [getEmail()=" + getEmail() + ", getNom()=" + getNom() + "]";
	}
	
	
}