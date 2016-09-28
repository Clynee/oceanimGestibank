package com.wha.springmvc.model;

public class CompteRemun extends Compte {
	
//-------------------------attributs--------------------------------------------
	
	
	private int txRemun;
	
//-------------------------constructeurs----------------------------------------
	
	
	public CompteRemun(){
		
		txRemun=0;
		
	}
    public CompteRemun(int txRemun){
		
		this.txRemun=txRemun;
		
	}
    
 //-------------------------méthodes----------------------------------------
	
    
	public int getTxRemun() {
		return txRemun;
	}
	public void setTxRemun(int txRemun) {
		this.txRemun = txRemun;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + txRemun;
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
		CompteRemun other = (CompteRemun) obj;
		if (txRemun != other.txRemun)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CompteRemun [getTxRemun()=" + getTxRemun() + ", hashCode()=" + hashCode() + "]";
	}
    
    
	

}
