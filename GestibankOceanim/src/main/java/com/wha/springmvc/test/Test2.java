package com.wha.springmvc.test;



import java.util.Iterator;
import java.util.List;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wha.springmvc.entities.Client;
import com.wha.springmvc.entities.Compte;
import com.wha.springmvc.entities.Transaction;
import com.wha.springmvc.service.IBanqueService;

public class Test2 {

	public static void main(String[] args) {
		// test methode consulter avec update dans persistence.xml

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		IBanqueService metier = (IBanqueService) context.getBean("metier");
		Compte cp = metier.consulterCompte("CC1");

		System.out.println("Solde :" + cp.getSolde());
		System.out.println("Date :" + cp.getDateCreation());
		System.out.println("Client:" + cp.getClient().getNomClient());
		System.out.println("Conseiller :" + cp.getConseiller().getNomConseiller());

		List<Transaction> ops = metier.consulterOperations("CC1", 0, 10);

		for (Transaction op : ops) {

			System.out.println("****************");
			System.out.println(op.getNumeroOperation());
			System.out.println(op.getDateOperation());
			System.out.println(op.getMontant());
			System.out.println(op.getClass().getSimpleName());
		}

		List<Client> clients = metier.findAllClients();
		System.out.println(clients.size());

	}

}
