package fr.formation.spring.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.spring.bll.PersonneManager;
import fr.formation.spring.entity.Personne;

@RestController
public class PersonneRestController {

	
	@Autowired
	PersonneManager pm;
	
	@RequestMapping(value="/rs/{id}", method = RequestMethod.GET)
	public ResponseEntity<Personne> getPersonne(@PathVariable("id") Integer id) {
		System.out.println("Recup de l'id : " + id);
		Optional<Personne> op = pm.trouver(id);
		
		if (!op.isPresent())
			return new ResponseEntity<Personne>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Personne>(op.get(), HttpStatus.OK);
	}



}
