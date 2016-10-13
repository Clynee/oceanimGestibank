//package com.wha.springmvc.test;
//
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.wha.springmvc.configuration.JpaConfiguration;
//import com.wha.springmvc.entities.Adresse;
//import com.wha.springmvc.entities.Client;
//import com.wha.springmvc.entities.CompteCourant;
//import com.wha.springmvc.entities.CompteRemunere;
//import com.wha.springmvc.entities.Conseiller;
//import com.wha.springmvc.service.BanqueServiceImpl;
//import com.wha.springmvc.service.IBanqueService;
//
//public class Test {
//
//	public static void main(String[] args) {
//		
//		
//		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
//		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfiguration.class);
//		IBanqueService metier=(IBanqueService) context.getBean(BanqueServiceImpl.class);//("banqueService");
//		metier.ajouterClient(new Client("C1", new Adresse(2, "jack cartier", 2000, "nantes")));
//		metier.ajouterClient(new Client("C2", new Adresse(3, "elvis longly", 06520, "rennes")));
//		
//		metier.ajouterConseiller(new Conseiller("E1"), null);
//		metier.ajouterConseiller(new Conseiller("E2"), 1L);
//		metier.ajouterConseiller(new Conseiller("E3"), 1L);
//		metier.affectConseillerToClient(1L, 1L);
//		metier.affectConseillerToClient(3L, 2L);
//		
//		metier.ajouterCompte(new CompteCourant("CC1", new Date(), 9000, 8000), 1L,2L );
//		metier.ajouterCompte(new CompteRemunere("CE1", new Date(), 40000, 5.5), 2L,2L );
//		
//		metier.crediter(5000, "CC1", 2L);
//		metier.debiter(6000, "CC1", 2L);
//		metier.virement(4000, "CC1", "CE1", 1L);
//		
//		
//		
//		
//
//	}
//
//}
