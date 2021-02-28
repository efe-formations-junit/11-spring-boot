package fr.formation.spring.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.spring.dal.PersonneDao;
import fr.formation.spring.entity.Personne;


@Service
public class PersonneManager {

	
	@Autowired
	PersonneDao pDao;
	
	public void ajout(Personne p) {
		pDao.save(p);
	}
	
	public Optional<Personne> trouver(int id) {
		return pDao.findById(id);
	}
	
	public List<Personne> liste() {
		return pDao.findAll();
	}
	
}
