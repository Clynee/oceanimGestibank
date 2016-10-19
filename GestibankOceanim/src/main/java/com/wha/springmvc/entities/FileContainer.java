package com.wha.springmvc.entities;

import org.springframework.web.multipart.MultipartFile;

public class FileContainer {
	
	  MultipartFile file;
	     
	    String description;
	 
	    public MultipartFile getFile() {
	        return file;
	    }
	 
	    public void setFile(MultipartFile file) {
	        this.file = file;
	    }
	 
	    public String getDescription() {
	        return description;
	    }
	 
	    public void setDescription(String description) {
	        this.description = description;
	    }
	 

}
