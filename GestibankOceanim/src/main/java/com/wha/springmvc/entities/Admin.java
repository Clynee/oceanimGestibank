package com.wha.springmvc.entities;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.wha.springmvc.constants.TypeRole;

@Entity
@DiscriminatorValue("AD")
public class Admin extends User{

	//----------------attributs------------------------------------------

		//private int matricule;
		
		//private String typeuser="BIGBOSS" ;
		
	// ---------------constructeurs----------------------------------------	
	public Admin() {
		setRoleUsers(TypeRole.ADMINISTRATEUR);
	}

	public Admin(long id, String username, Adresse address, String email) {
		this();
		this.setAddress(address);
		this.setEmail(email);
		this.setId(id);
		this.setUsername(username);
	}
	

	
}
