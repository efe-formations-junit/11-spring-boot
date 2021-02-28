package fr.formation.spring.bll;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fr.formation.spring.dal.PersonneDao;
import fr.formation.spring.entity.Personne;

import static org.mockito.Mockito.*;


@SpringBootTest(classes = {PersonneManager.class})
@ExtendWith(MockitoExtension.class)
public class PersonneManagerTest {

	
	@Autowired
	PersonneManager pm;
	
	@MockBean
	PersonneDao pDao;

	
	@Test
	public void testListePersonne() {
		List<Personne> liste = new ArrayList<Personne>();
		liste.add(new Personne());
		liste.add(new Personne());
		
		Mockito.when(pDao.findAll()).thenReturn(liste);
		
		List<Personne> listeP = pm.liste();
		System.out.println("1");
		
		assertEquals(2, listeP.size());
	}
	
	@Test
	public void testUnePersonne() {
		Personne p = new Personne(1, "Legrand", "Marco", 65);
		Optional<Personne> op = Optional.of(p);
		
		Mockito.when(pDao.findById(anyInt())).thenReturn(op);
		
		Optional<Personne> nouv = pm.trouver(1);
		System.out.println("2");
	
		assertEquals(true, nouv.isPresent());
		assertEquals(65, nouv.get().getAge());
	}
	
}
