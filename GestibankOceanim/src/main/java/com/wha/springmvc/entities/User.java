package com.wha.springmvc.entities;


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
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ROLE",discriminatorType=DiscriminatorType.STRING,length=2)
public class User {
	//@Transient
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	//@Transient
	private String username;
	//@Transient
	@OneToOne(cascade = {CascadeType.ALL})
    /*@JoinColumn(
           name="idAdresse",
         referencedColumnName="idAdresse"
     )*/
	@JoinColumn(name="idAdresse")
	private Adresse address;
	
	
	//@Transient
	private String email;
	//@Transient
    private String password;
	//@Transient
	private int roleUsers;

	public User(){
		id=0;
	}
	
	public User(long id, String username, Adresse address, String email){
		
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
		return "User [id=" + id + ", nom=" + username + ", adresse=" + address
				+ ", email=" + email + "]";
	}
	

}