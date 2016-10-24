package com.wha.springmvc.controller;
 
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.wha.springmvc.entities.Admin;
import com.wha.springmvc.entities.Adresse;
import com.wha.springmvc.entities.Client;
import com.wha.springmvc.entities.Compte;
import com.wha.springmvc.entities.CompteCourant;
import com.wha.springmvc.entities.CompteRemunere;
import com.wha.springmvc.entities.Conseiller;
import com.wha.springmvc.entities.DemandeInscription;
import com.wha.springmvc.entities.Document;
import com.wha.springmvc.entities.FicheInscription;
import com.wha.springmvc.entities.FileContainer;
import com.wha.springmvc.entities.Message;
import com.wha.springmvc.entities.MessageRecu;
import com.wha.springmvc.entities.Notification;
import com.wha.springmvc.entities.NotificationMessage;
import com.wha.springmvc.entities.User;
import com.wha.springmvc.service.BanqueServiceImpl;
import com.wha.springmvc.service.IBanqueService;
import com.wha.springmvc.service.UserService;
import com.wha.springmvc.util.FileValidator;
 
@RestController
public class HelloWorldRestController {
    @Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work
    
    @Autowired
    IBanqueService banqueService;
    
    @RequestMapping(value="/test", method = RequestMethod.GET)
    public ResponseEntity<Client> monTest(){
    	/*----- Les addresses ------*/
		Adresse adresse1 = new Adresse();
		adresse1.setNumDeRue(5);
		adresse1.setNomRue("Camilles Desmoulins");
		adresse1.setCodePostale(35000);
		adresse1.setVille("Rennes");

		Adresse adresse2 = new Adresse();
		adresse2.setNumDeRue(7);
		adresse2.setNomRue("Albert Einstein");
		adresse2.setCodePostale(44300);
		adresse2.setVille("Nantes");

		Adresse adresse3 = new Adresse();
		adresse3.setNumDeRue(5);
		adresse3.setNomRue("Camilles Desmoulins");
		adresse3.setCodePostale(35000);
		adresse3.setVille("Rennes");

		Adresse adresse4 = new Adresse();
		adresse4.setNumDeRue(34);
		adresse4.setNomRue("Gambetta");
		adresse4.setCodePostale(69300);
		adresse4.setVille("Lyon");

		/*---- L'admin ---*/
		Admin admin = new Admin();
		admin.setUsername("wajii");
		admin.setPassword("1111");

		/*---- Les conseillers ----- */
		Conseiller cons = new Conseiller();
		cons.setUsername("celine");
		cons.setPassword("1111");
		cons.setCodeConseiller(1L);
		cons.setNom("Galland");
		cons.setPrenom("Céline");

		Conseiller cons1 = new Conseiller();
		cons1.setUsername("boubou");
		cons1.setPassword("1111");
		cons1.setCodeConseiller(2L);
		cons1.setNom("BOUBOU");
		cons1.setPrenom("Doudou");

		/*-------- Les clients --------*/
		Client cli1 = new Client();
		cli1.setUsername("aissa");
		cli1.setPassword("1111");
		cli1.setAddress(adresse3);
		cli1.setEmail("aissa@gesti.com");
		cli1.setNom("MEDJKOUNE");
		cli1.setPrenom("Aissa");
		cli1.setSituationMaritale("marié");
		cli1.setNbrEnfants(3);
		cli1.setAddress(adresse1);
		cli1.setTel("0621345653");
		cli1.setCodeClient(1L);

		Client cli2 = new Client();
		cli2.setUsername("noufel");
		cli2.setPassword("1111");
		cli2.setAddress(adresse1);
		cli2.setEmail("noufel@gesti.com");
		cli2.setNom("ADNANE");
		cli2.setPrenom("Noufel");
		cli2.setSituationMaritale("marié");
		cli2.setNbrEnfants(3);
		cli2.setAddress(adresse2);
		cli2.setTel("0695385170");
		cli2.setCodeClient(2L);
		/*--- Les comptes ----*/

		Compte c1 = new CompteCourant("CC1", 9000, 8000);
		Compte c2 = new CompteRemunere("CE1", 40000, 8000, 5.5);
		Compte c3 = new CompteRemunere("CE2", 40000, 8000, 5.5);

		/*-- Les Fiches d'inscription -- */

		FicheInscription fiche = new FicheInscription();
		fiche.setAdresse(adresse3);
		fiche.setDate(new Date((new java.util.Date()).getTime()));
		fiche.setEmail("ficheP@gestibank.oceanim");
		fiche.setNom("BRAHIM");
		fiche.setPrenom("Lemine");
		fiche.setSalaireMoyen(5000);

		FicheInscription fiche1 = new FicheInscription();
		fiche1.setAdresse(adresse4);
		fiche1.setDate(new Date((new java.util.Date()).getTime()));
		fiche1.setEmail("ficheD@gestibank.oceanim");
		fiche1.setNom("ADNANE");
		fiche1.setPrenom("SP");
		fiche1.setSalaireMoyen(5000);

		/* --- Les Demandes --- */
		DemandeInscription demande1 = new DemandeInscription();

		demande1.setExp(admin);
		demande1.setMessage("Ma première demande");
		demande1.setDateDemande(new java.util.Date());
		demande1.setFicheInsc(fiche1);

		DemandeInscription demande2 = new DemandeInscription();
		demande2.setExp(admin);
		demande2.setMessage("Ma deuxieme demande");
		demande2.setDateDemande(new java.util.Date());
		demande2.setFicheInsc(fiche);
		
		
		/*-- Les notifications ----*/
		NotificationMessage notif = new NotificationMessage();
		
		/*--- Message ---*/
		Message message = new MessageRecu();
		
		/*----- La persistence ----*/
		
		banqueService.ajouterUser(admin);

		banqueService.ajouterConseiller(cons);
		banqueService.ajouterConseiller(cons1);
		
		
		
		banqueService.ajouterClient(cli1);
		banqueService.ajouterClient(cli2);

		banqueService.affectConseillerToClient(2L, 4L);
		banqueService.affectConseillerToClient(2L, 5L);

		banqueService.ajouterCompte(c1, 4L);
		banqueService.ajouterCompte(c2, 4L);
		banqueService.ajouterCompte(c3, 5L);

		banqueService.ajouterDemande(demande1);
		banqueService.ajouterDemande(demande2);

		// banqueService.crediter(5000, "CC1");
		// banqueService.debiter(6000, "CC1");
		banqueService.virement(4000, "CC1", "CE1");
		banqueService.virement(2000, "CE1", "CC1");
		banqueService.virement(4000, "CC1", "CE1");
		banqueService.virement(2000, "CE1", "CC1");
		
		//
		message.setConcerne(cli1);
		banqueService.ajouterMessage(message);
		notif.setDestinateur(cli1);
		notif.setMessage(message);
		banqueService.ajouterNotification(notif);
		
    	return new ResponseEntity<Client>(cli1,HttpStatus.OK);
    }
    
    
    @RequestMapping(value="/clients", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> listClients(){
    	List<Client> clients = banqueService.findAllClients();
    	
    	if(clients.isEmpty()){
            return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    }
    
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public ResponseEntity<List<com.wha.springmvc.entities.User>> listUsers(){
    	List<com.wha.springmvc.entities.User> users = banqueService.findAllUsers();
    	
    	if(users.isEmpty()){
            return new ResponseEntity<List<com.wha.springmvc.entities.User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<com.wha.springmvc.entities.User>>(users, HttpStatus.OK);
    }
    
    
    @RequestMapping(value="/conseillers", method = RequestMethod.GET)
    public ResponseEntity<List<Conseiller>> listConseillers(){
    	List<Conseiller> conseillers = banqueService.getConseillers();
    	
    	if(conseillers.isEmpty()){
            return new ResponseEntity<List<Conseiller>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Conseiller>>(conseillers, HttpStatus.OK);
    }
    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single User--------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getUsername());
 
        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        userService.saveUser(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a User --------------------------------------------------------
  /*   
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        System.out.println("Updating User " + id);
         
        User currentUser = userService.findById(id);
         
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        currentUser.setUsername(user.getUsername());
        currentUser.setAddress(user.getAddress());
        currentUser.setEmail(user.getEmail());
        
        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
 
    */
    
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Users --------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        System.out.println("Deleting All Users");
 
        userService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
    
//////////////////////////////////////////////////////////////////
    
@RequestMapping(value = { "/add-document-{userId}" }, method = RequestMethod.GET)
public String addDocuments(@PathVariable long userId, ModelMap model) {
User user = userService.findById(userId);

//findById(userId);
//.findById(userId);
model.addAttribute("user", user);

FileContainer fileModel = new FileContainer();
model.addAttribute("fileBucket", fileModel);

List<Document> documents = banqueService.findAllDocByUserId(userId);
//findAllByUserId(userId);
model.addAttribute("documents", documents);

return "managedocuments";
}
/////////////////////////////////////////////////////////////////

@RequestMapping(value = { "/download-document-{userId}-{docId}" }, method = RequestMethod.GET)
public String downloadDocument(@PathVariable int userId, @PathVariable int docId, HttpServletResponse response) throws IOException {
Document document = banqueService.findDocById(docId);
//findById(docId);
response.setContentType(document.getType());
response.setContentLength(document.getContent().length);
response.setHeader("Content-Disposition","attachment; filename=\"" + document.getName() +"\"");

FileCopyUtils.copy(document.getContent(), response.getOutputStream());

return "redirect:/add-document-"+userId;
}
//////////////////////////////////

@RequestMapping(value = { "/delete-document-{userId}-{docId}" }, method = RequestMethod.GET)
public String deleteDocument(@PathVariable int userId, @PathVariable int docId) {
banqueService.deleteDocById(docId);
//.deleteById(docId);
return "redirect:/add-document-"+userId;
}

///////////////////////////////////////



@RequestMapping(value = { "/add-document-{userId}" }, method = RequestMethod.POST)
public String uploadDocument(@Valid FileContainer fileBucket, BindingResult result, ModelMap model, @PathVariable int userId) throws IOException{

if (result.hasErrors()) {
System.out.println("validation errors");
User user = userService.findById(userId);
model.addAttribute("user", user);

List<Document> documents = banqueService.findAllDocByUserId(userId);
//findAllByUserId(userId);
model.addAttribute("documents", documents);

return "managedocuments";
} else {

System.out.println("Fetching file");

User user = userService.findById(userId);
model.addAttribute("user", user);


saveDocument(fileBucket, user);

return "redirect:/add-document-"+userId;
}
}


private void saveDocument(FileContainer fileBucket, User user) throws IOException{

Document document = new Document();

MultipartFile multipartFile = fileBucket.getFile();

document.setName(multipartFile.getOriginalFilename());
document.setDescription(fileBucket.getDescription());
document.setType(multipartFile.getContentType());
document.setContent(multipartFile.getBytes());
document.setUser(user);
//setUser(user);
banqueService.saveDoc(document);
}


}