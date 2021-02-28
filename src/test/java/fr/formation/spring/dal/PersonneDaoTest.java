package fr.formation.spring.dal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import fr.formation.spring.entity.Personne;

@DataJpaTest
public class PersonneDaoTest {

	@Autowired
	PersonneDao pDao;
	
	@Test
	@Sql("/createUser.sql")
	public void testListe() {
		List<Personne> liste = pDao.findAll();
		
		assertEquals(2, liste.size());
	}
	
	@Test
	public void testAjout() {
		Personne p = new Personne("Leblond", "Luc", 41);

		pDao.save(p);
		
		List<Personne> liste = pDao.findAll();
		assertEquals(1, liste.size());
		assertTrue(liste.get(0).getId() > 0);
		assertEquals("Leblond", liste.get(0).getNom());
		assertEquals("Luc", liste.get(0).getPrenom());
		assertEquals(41, liste.get(0).getAge());
		
		
	}
}
