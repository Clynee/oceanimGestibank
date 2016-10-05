package com.wha.springmvc.model;

import com.wha.springmvc.model.User.Roles;

public class User {
	public enum Roles{user,admin,conseiller,client};
	
	
	
	public static final Roles ROLE = Roles.user;
	private long id;
	
	private String username;
	
	private String address;
	
	private String email;
	
	private String password;

	
	public User(){
	}
	
	public User(long id, String username, String address, String email,String password){
		this.id = id;
		this.username = username;
		this.address = address;
		this.email = email;
		this.password = password;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
