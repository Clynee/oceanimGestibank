package com.wha.springmvc.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ROLE", discriminatorType = DiscriminatorType.STRING, length = 2)
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String username;
	private String password;
	private String nom;
	private String prenom;
	private String tel;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "user_addresse",
	        joinColumns = @JoinColumn(
	            name = "user_id", 
	            referencedColumnName = "id"),
	        inverseJoinColumns = @JoinColumn(
	            name = "addresse_id", 
	            referencedColumnName = "idAdresse")
	    )
	private Adresse address;
	/*
	 @JoinColumn( name="idAdresse", referencedColumnName="idAdresse" )
	 
	/*
	@JoinColumn(name = "idAdresse")
	*/
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Document> Documents = new HashSet<Document>();
	@JsonIgnore
	public Set<Document> getDocuments() {
		return Documents;
	}

	public void setDocuments(Set<Document> Documents) {
		this.Documents = Documents;
	}

	private String email;
	// @Transient

	// @Transient
	private int roleUsers;

	public User() {
		id = 0;
	}

	public User(long id, String username, Adresse address, String email) {
		this.id = id;
		this.username = username;
		this.address = address;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Adresse getAddress() {
		return address;
	}

	public void setAddress(Adresse address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleUsers() {
		return roleUsers;
	}

	public void setRoleUsers(int roleUsers) {
		this.roleUsers = roleUsers;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", adresse=" + address + ", email=" + email + "password = "
				+ password + "]";
	}
	
	
	
}