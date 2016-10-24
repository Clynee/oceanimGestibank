package com.wha.springmvc.enums;

import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;

public enum EtatDemande {
	EnCours(1),
    EnAttente(2),
    Validee(3);
	
	private int value;

	
	private EtatDemande(int val){
		value = val;
	}
	
	public int toInt() {
        return value;
    }
	
	public static EtatDemande fromInt(int val){
		switch(val){
			case 1 : 
				return EnCours;
			case 2 : 
				return EnAttente;
			case 3 :
				return Validee;
			default :
				return null;
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
