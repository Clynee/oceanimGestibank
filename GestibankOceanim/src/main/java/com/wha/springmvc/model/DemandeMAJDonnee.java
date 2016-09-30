package com.wha.springmvc.model;

import java.util.Date;

public class DemandeMAJDonnee extends DemandeClient {
	
//-------------------------attributs--------------------------------------------
    
	
    private int  ref;
    private Date dateDemande;
    
    private Client client;
    private Compte compte;
	
	
//-------------------------constructeurs----------------------------------------
    
	public DemandeMAJDonnee()
	{
		this.ref=0;
    }
	
    public DemandeMAJDonnee(int num, Date date, Client client, Compte compte)
    {			
		this.ref=num;
		this.client=client;
		this.compte=compte;	
    }
    
//------------------------------------------méthodes-------------------------------------------------


}
