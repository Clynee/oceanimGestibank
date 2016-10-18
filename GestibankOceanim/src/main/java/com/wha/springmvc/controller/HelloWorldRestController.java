package com.wha.springmvc.controller;
 
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wha.springmvc.entities.Admin;
import com.wha.springmvc.entities.Adresse;
import com.wha.springmvc.entities.Client;
import com.wha.springmvc.entities.Compte;
import com.wha.springmvc.entities.CompteCourant;
import com.wha.springmvc.entities.CompteRemunere;
import com.wha.springmvc.entities.Conseiller;
import com.wha.springmvc.model.User;
import com.wha.springmvc.service.BanqueServiceImpl;
import com.wha.springmvc.service.IBanqueService;
import com.wha.springmvc.service.UserService;
 
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
    	adresse1.setNumDeRue(5); adresse1.setNomRue("Camilles Desmoulins");
    	adresse1.setCodePostale(35000); adresse1.setVille("Rennes");
    	
    	Adresse adresse2 = new Adresse();
    	adresse2.setNumDeRue(7); adresse2.setNomRue("Albert Einstein");
    	adresse2.setCodePostale(44300); adresse2.setVille("Nantes");
    	
    	
    	
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
    	
    	
    	
    	/*-------- Les clients --------*/
    	Client cli1 = new Client();
    	cli1.setUsername("aissa"); cli1.setPassword("1111");
    	cli1.setAddress(adresse1);cli1.setEmail("aissa@gesti.com");
    	cli1.setNom("MEDJKOUNE"); cli1.setPrenom("Aissa");
    	cli1.setSituationMaritale("marié");cli1.setNbrEnfants(3);
    	cli1.setAddress(adresse1);cli1.setTel("0621345653");
    	cli1.setCodeClient(1L);
    	
    	Client cli2 = new Client();
    	cli2.setUsername("noufel"); cli2.setPassword("1111");
    	cli2.setAddress(adresse2);cli2.setEmail("noufel@gesti.com");
    	cli2.setNom("ADNANE"); cli2.setPrenom("Noufel");
    	cli2.setSituationMaritale("marié");cli2.setNbrEnfants(3);
    	cli2.setAddress(adresse2);cli2.setTel("0695385170");
    	cli2.setCodeClient(2L);
    	/*--- Les comptes ----*/ 
    	
    	Compte c1 = new CompteCourant("CC1", 9000, 8000);
    	Compte c2 = new CompteRemunere("CE1", 40000,8000, 5.5);
    	Compte c3 = new CompteRemunere("CE2", 40000,8000, 5.5);
    	
    	/*----- La persistance ----*/
    	
    	banqueService.ajouterConseiller(cons);
    	banqueService.ajouterClient(cli1);
    	banqueService.ajouterClient(cli2);
    	
    	banqueService.affectConseillerToClient(1L, 2L);
    	banqueService.affectConseillerToClient(1L, 3L);
    	
    	banqueService.ajouterCompte(c1, 2L);
    	banqueService.ajouterCompte(c2, 2L);
    	banqueService.ajouterCompte(c3, 3L);
    	
    	//banqueService.crediter(5000, "CC1");
    	//banqueService.debiter(6000, "CC1");
    	banqueService.virement(4000, "CC1", "CE1");
    	banqueService.virement(2000, "CE1", "CC1");
    	banqueService.virement(4000, "CC1", "CE1");
    	banqueService.virement(2000, "CE1", "CC1");
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
 
}