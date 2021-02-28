package fr.formation.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.spring.bll.PersonneManager;
import fr.formation.spring.entity.Personne;

@Controller
public class PersonneController {

	
	@Autowired
	PersonneManager pm;
	
	@GetMapping(path = "/liste")
	public String lister(ModelMap map) {
		
		map.addAttribute("liste", pm.liste());
		return "liste";
	}
	
	@PostMapping(path = "/ajout")
	public String ajout(Personne p, ModelMap map) {
		
		pm.ajout(p);
		map.addAttribute("liste", pm.liste());
		return "liste";
	}
}
