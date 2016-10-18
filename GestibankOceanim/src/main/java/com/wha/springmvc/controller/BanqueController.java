package com.wha.springmvc.controller;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wha.springmvc.entities.BanqueForm;
import com.wha.springmvc.entities.Client;
import com.wha.springmvc.entities.Compte;
import com.wha.springmvc.entities.Transaction;
import com.wha.springmvc.entities.User;
import com.wha.springmvc.service.IBanqueService;
@Controller
public class BanqueController {
	@Autowired
	private IBanqueService banqueService;
	
	
	@RequestMapping(value="/clients/{idConseiller}", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> listClients(@PathVariable("idConseiller") long idConseiller){
    	List<Client> clients = banqueService.findClientsByConseiller(idConseiller);
    	
    	if(clients.isEmpty()){
            return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    }
    
	
	@RequestMapping(value = "/virement/", method = RequestMethod.POST)
    public ResponseEntity<Void> virement(@RequestBody Map<String,String> infosVirement) {
    	
		banqueService.virement(Double.parseDouble(infosVirement.get("montantVirement")), infosVirement.get("compteDebite"), infosVirement.get("compteCredit"));
		System.out.println(infosVirement);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
	
	
	@RequestMapping(value = "/operations/{codeCompte}", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getOperations(@PathVariable("codeCompte") String codeCompte) {
		
		int nbOperation = banqueService.getNombreOperation(codeCompte);
		List<Transaction> listOperations = banqueService.consulterOperations(codeCompte, nbOperation, nbOperation);
        return new ResponseEntity<List<Transaction>>(listOperations, HttpStatus.OK);
    }
	
	
	
	@RequestMapping(value = "/comptes/", method = RequestMethod.POST)
    public ResponseEntity<List<Compte>> getComtes(@RequestBody Client user) {
		System.out.println("User à sauvegarder");
		System.out.println(user);
		List<Compte> comptes = banqueService.getComptesByClient(user.getCodeClient());
        return new ResponseEntity<List<Compte>>(comptes, HttpStatus.OK);
    }
	
	
	
	
	
	@RequestMapping(value = "/updateUser/", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody Client user) {
		System.out.println("User à sauvegarder");
		System.out.println(user);
		banqueService.miseAjourClient((Client)user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
 
	
	
	
	
/*	
	
  @RequestMapping(value="/index")
  public String index(Model model){
	  model.addAttribute("banqueForm", new BanqueForm());
	  return "banque";
  }
  
  @RequestMapping(value="/chargerCompte")
  public String charger(@Valid BanqueForm bf,BindingResult bindingResult,Model model){
	  if(bindingResult.hasErrors()){
		  return "banque";
	  }
	  
	 chargerCompte(bf);
	  model.addAttribute("banqueForm", bf);
	  return "banque";
  }
  
  @RequestMapping(value="/saveOperation")
  public String saveOp(@Valid BanqueForm bf,BindingResult bindingResult){
	  
	
		  try {
			if (bindingResult.hasErrors()) {
				  return "banque";
			  }	
			  
if (bf.getAction()!=null) {
	
	
	
	
	
  if (bf.getTypeOperation().equals("VER")) {
			  metier.crediter(bf.getMontant(),bf.getCode(),1L);
} else if (bf.getTypeOperation().equals("RET")) {
			  metier.debiter(bf.getMontant(),bf.getCode(),1L);	
} else if (bf.getTypeOperation().equals("VIR")) {
			  metier.virement(bf.getMontant(),bf.getCode(),bf.getCode2(),1L);
     }
  
  
  
  }
   /*
  if (bindingResult.hasErrors()) {
			  return "banque";
  }	  
  */
	/*
chargerCompte(bf);
		  } catch (Exception e) {
				bf.setException(e.getMessage());
			}
		  
		
	  return "banque";
  }
  
  public void chargerCompte(BanqueForm bf){
	 
		  try {
			
			Compte cp=metier.consulterCompte(bf.getCode());
			  bf.setTypeCompte(cp.getClass().getSimpleName());
			  bf.setCompte(cp);	
			  List<Transaction> ops=metier.consulterOperations(bf.getCode(),0,5);
			  bf.setOperations(ops);
		} catch (Exception e) {
			bf.setException(e.getMessage());
		}
	  
  }
  */
  
}

