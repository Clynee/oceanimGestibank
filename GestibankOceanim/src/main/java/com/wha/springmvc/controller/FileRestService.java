package com.wha.springmvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wha.springmvc.entities.Document;
import com.wha.springmvc.entities.FileContainer;
import com.wha.springmvc.entities.User;
import com.wha.springmvc.service.IBanqueService;
import com.wha.springmvc.service.UserService;
import com.wha.springmvc.util.FileValidator;



public class FileRestService {
	
	
	 @Autowired
	    UserService userService;  //Service which will do all data retrieval/manipulation work
	    
	    @Autowired
	    IBanqueService banqueService;
	    
	    
	    /////////////
		
		
		
		
		@Autowired
		MessageSource messageSource;

		@Autowired
		FileValidator fileValidator;
		
		@InitBinder("fileBucket")
		protected void initBinder(WebDataBinder binder) {
		   binder.setValidator(fileValidator);
		}
		
		
		
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
