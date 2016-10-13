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

import com.wha.springmvc.entities.Adresse;
import com.wha.springmvc.entities.Client;
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
    	Client cli = new Client("C1", new Adresse(2, "jack cartier", 2000, "nantes"));
    	cli.setUsername("aissa");
    	cli.setPassword("1111");
    	banqueService.ajouterClient(cli);
    	Client cli2=new Client("C2", new Adresse(3, "elvis longly", 06520, "rennes"));
    	cli2.setUsername("noufel");
    	cli2.setPassword("1111");
    	banqueService.ajouterClient(cli2);
    	
    	Conseiller cons = new Conseiller("E1");
    	cons.setUsername("celine");
    	cons.setPassword("1111");
    	banqueService.ajouterConseiller(cons);
    	banqueService.ajouterConseiller(new Conseiller("E2"));
    	banqueService.ajouterConseiller(new Conseiller("E3"));
    	banqueService.affectConseillerToClient(3L, 1L);
    	banqueService.affectConseillerToClient(3L, 2L);
	
    	/*
    	banqueService.ajouterCompte(new CompteCourant("CC1", new Date((new java.util.Date()).getTime()), 9000, 8000), 1L);
    	banqueService.ajouterCompte(new CompteRemunere("CE1", new Date((new java.util.Date()).getTime()), 40000, 5.5), 3L);
	
    	banqueService.crediter(5000, "CC1", 2L);
    	banqueService.debiter(6000, "CC1", 2L);
    	banqueService.virement(4000, "CC1", "CE1", 1L);*/
    	return new ResponseEntity<Client>(cli,HttpStatus.OK);
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