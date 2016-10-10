package com.wha.springmvc.entities;

public enum EtatComptes {
	
	
	    VALIDE(1),
	    INVALIDE(2),
	    ENCOURS(3);
	    

	    private int value;

	    private EtatComptes(int val) {
	        value = val;
	    }

	    public int toInt() {
	        return value;
	    }

	    public static EtatComptes fromInt(int val) {
	        switch(val) {
	            case 1 :
	                return VALIDE;
	            case 2:
	                return INVALIDE;
	            case 3:
	                return ENCOURS;
	           
	            default:
	                return ENCOURS;
	        }
	    }

	    @Override
	    public String toString() {
	        return value + " ";
	    }

	    public int getValue() {
	        return value;
	    }


}
