package com.wha.springmvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {
		
	private static Logger logger = Logger.getLogger(IndexController.class);
	
	  @RequestMapping(method = RequestMethod.GET)
	    public String getIndexPage() {
  //return "index";//"UserManagement";
		  return "index";
	    }

}