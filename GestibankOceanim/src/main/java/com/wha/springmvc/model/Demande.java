package com.wha.springmvc.model;

import java.util.Date;

public class Demande {
	
//-------------------------attributs--------------------------------------------
    
			
	        private int  ref;
	        private User user;
			private Date dateDemande;
			
			
//-------------------------constructeurs----------------------------------------
		    
			public Demande()
			{
				this.ref=0;
		    }
			
		    public Demande(int num, User utilisateur, Date date)
		    {			
				this.ref=num;
				this.user=utilisateur;
				this.dateDemande=date;
				
		    }

		    
//------------------------------------------méthodes-------------------------------------------------

		    
		    
			public int getRef() {
				return ref;
			}

			public void setRef(int ref) {
				this.ref = ref;
			}

			public User getUser() {
				return user;
			}

			public void setUser(User user) {
				this.user = user;
			}

			public Date getDateDemande() {
				return dateDemande;
			}

			public void setDateDemande(Date dateDemande) {
				this.dateDemande = dateDemande;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((dateDemande == null) ? 0 : dateDemande.hashCode());
				result = prime * result + ref;
				result = prime * result + ((user == null) ? 0 : user.hashCode());
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
				Demande other = (Demande) obj;
				if (dateDemande == null) {
					if (other.dateDemande != null)
						return false;
				} else if (!dateDemande.equals(other.dateDemande))
					return false;
				if (ref != other.ref)
					return false;
				if (user == null) {
					if (other.user != null)
						return false;
				} else if (!user.equals(other.user))
					return false;
				return true;
			}

			@Override
			public String toString() {
				return "Demande [getRef()=" + getRef() + ", getUser()=" + getUser() + ", getDateDemande()="
						+ getDateDemande() + ", hashCode()=" + hashCode() + "]";
			}
			
}
