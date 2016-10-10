package com.wha.springmvc.enums;

public enum RolesUsers {
	
	ADMINISTRATEUR(1),
    CONSEILLER(2),
    CLIENT(3);
    

    private int value;

    private RolesUsers(int val) {
        value = val;
    }

    public int toInt() {
        return value;
    }

    public static RolesUsers fromInt(int val) {
        switch(val) {
            case 1 :
                return ADMINISTRATEUR;
            case 2:
                return CONSEILLER;
            case 3:
                return CLIENT;
           
            default:
                return CLIENT;
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
