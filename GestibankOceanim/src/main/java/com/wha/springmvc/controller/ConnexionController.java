package com.wha.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.model.Conseiller;
import com.wha.springmvc.model.User;
import com.wha.springmvc.service.ConnexionService;

@RestController
public class ConnexionController {
	@Autowired
	ConnexionService connexionService;

	
	@RequestMapping(value = "/seConnecter/{ident}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Conseiller> getUser(@PathVariable("ident") String ident) {
        System.out.println("Fetching User with id " + ident);
        Conseiller  cons = connexionService.seConnecter(ident, "1111");
        if (cons == null) {
            System.out.println("User with id " + ident + " not found");
            return new ResponseEntity<Conseiller>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Conseiller>(cons, HttpStatus.OK);
    }
}
