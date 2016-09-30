package com.wha.springmvc.model;

import java.util.Date;
import java.util.List;

public class Transaction {
	
	//-------------------------attributs--------------------------------------------
    
		private int numOperation;
		private Compte compteExp;
		private Compte compteRecep;
		private Date dateTransaction;
		private double montantTransaction;
		
	//-------------------------constructeurs----------------------------------------
	    
		public Transaction()
		{
			this.numOperation=0;
	    }
		
	    public Transaction(int code, Compte compteExp, Compte compteRecep, Date dateTransaction, double montantTransaction)
	    {			
			this.numOperation=code;
			this.compteExp=compteExp;
			this.compteRecep=compteRecep;
			this.dateTransaction=dateTransaction;
			this.montantTransaction=montantTransaction;
	    }
	    
	  //------------------------------------méthodes---------------------------------
	    

		public int getNumOperation() {
			return numOperation;
		}

		public void setNumOperation(int numOperation) {
			this.numOperation = numOperation;
		}

		public Compte getCompteExp() {
			return compteExp;
		}

		public void setCompteExp(Compte compteExp) {
			this.compteExp = compteExp;
		}

		public Compte getCompteRecep() {
			return compteRecep;
		}

		public void setCompteRecep(Compte compteRecep) {
			this.compteRecep = compteRecep;
		}

		public Date getDateTransaction() {
			return dateTransaction;
		}

		public void setDateTransaction(Date dateTransaction) {
			this.dateTransaction = dateTransaction;
		}

		public double getMontantTransaction() {
			return montantTransaction;
		}

		public void setMontantTransaction(double montantTransaction) {
			this.montantTransaction = montantTransaction;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((compteExp == null) ? 0 : compteExp.hashCode());
			result = prime * result + ((compteRecep == null) ? 0 : compteRecep.hashCode());
			result = prime * result + ((dateTransaction == null) ? 0 : dateTransaction.hashCode());
			long temp;
			temp = Double.doubleToLongBits(montantTransaction);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + numOperation;
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
			Transaction other = (Transaction) obj;
			if (compteExp == null) {
				if (other.compteExp != null)
					return false;
			} else if (!compteExp.equals(other.compteExp))
				return false;
			if (compteRecep == null) {
				if (other.compteRecep != null)
					return false;
			} else if (!compteRecep.equals(other.compteRecep))
				return false;
			if (dateTransaction == null) {
				if (other.dateTransaction != null)
					return false;
			} else if (!dateTransaction.equals(other.dateTransaction))
				return false;
			if (Double.doubleToLongBits(montantTransaction) != Double.doubleToLongBits(other.montantTransaction))
				return false;
			if (numOperation != other.numOperation)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Transaction [getNumOperation()=" + getNumOperation() + ", getCompteExp()=" + getCompteExp()
					+ ", getCompteRecep()=" + getCompteRecep() + ", getDateTransaction()=" + getDateTransaction()
					+ ", getMontantTransaction()=" + getMontantTransaction() + ", hashCode()=" + hashCode() + "]";
		}

	
	    
	    

}
