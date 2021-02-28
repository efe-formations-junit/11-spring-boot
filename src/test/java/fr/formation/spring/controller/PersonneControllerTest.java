package fr.formation.spring.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import fr.formation.spring.bll.PersonneManager;
import fr.formation.spring.entity.Personne;

@WebMvcTest
public class PersonneControllerTest {

	@Autowired
	PersonneController pc;
	
	
	@MockBean
	PersonneManager pm;
	
	@Autowired
    private MockMvc mockMvc;
	

	@Test
	public void testListe2() throws Exception {
		List<Personne> liste = new ArrayList<Personne>();
		
		liste.add(new Personne(1, "Legrand", "Marco", 65));
		liste.add(new Personne(2, "Legmoyen", "Jeanne", 32));
		
		when(pm.liste()).thenReturn(liste);
		
		this.mockMvc.perform(get("/liste"))
        .andExpect(status().isOk())
        .andExpect(view().name("liste"))
        .andExpect(model().attribute("liste",liste));
		
		
	}
}
