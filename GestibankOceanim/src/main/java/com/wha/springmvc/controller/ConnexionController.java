package com.wha.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.entities.User;
import com.wha.springmvc.service.ConnexionService;

@RestController
public class ConnexionController {
	@Autowired
	ConnexionService connexionService;
	@RequestMapping(value = "/seConnecter/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List> getUser(@RequestBody User u,HttpServletRequest request) {
        System.out.println("Fetching User with id " + u);
        User  user = connexionService.seConnecter(u.getUsername(), u.getPassword());
        if (user == null) {
            System.out.println("User with id " + u.getUsername() + " not found");
            return new ResponseEntity<List>(HttpStatus.NOT_FOUND);
        }
        
        HttpSession session = request.getSession();
        List l = new ArrayList<>();
        l.add(user);
        l.add(session.getId());
        /*JSONObject userData = new JSONObject();
        try {
			//userData.put("sessionID",session.getId());
			userData.put("user", user);
			//session.setAttribute("user" , user);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        //System.out.println(userData);
       // ResponseEntity<Object> a = new ResponseEntity<Object>(userData, HttpStatus.OK);
        //System.out.println(a);
        return new ResponseEntity<List>(l, HttpStatus.OK);
    }
}
