/*package com.wha.springmvc.controller;


import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wha.springmvc.entities.BanqueForm;
import com.wha.springmvc.entities.Compte;
import com.wha.springmvc.entities.Transaction;
import com.wha.springmvc.service.IBanqueService;
@Controller
public class BanqueController {
	@Autowired
	private IBanqueService metier;
  @RequestMapping(value="/index")
  public String index(Model model){
	  model.addAttribute("banqueForm", new BanqueForm());
	  return "banque";
  }
  
  @RequestMapping(value="/chargerCompte")
  //@Valid
  public String charger( BanqueForm bf,BindingResult bindingResult,Model model){
	  if(bindingResult.hasErrors()){
		  return "banque";
	  }
	  
	 chargerCompte(bf);
	  model.addAttribute("banqueForm", bf);
	  return "banque";
  }
  
  @RequestMapping(value="/saveOperation")
  //@Valid
  public String saveOp( BanqueForm bf,BindingResult bindingResult){
	  
	
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
   
  if (bindingResult.hasErrors()) {
			  return "banque";
  }	  
  
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
}

*/