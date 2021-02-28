package fr.formation.spring.rest;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import fr.formation.spring.bll.PersonneManager;
import fr.formation.spring.controller.PersonneController;
import fr.formation.spring.entity.Personne;

@WebMvcTest
public class PersonneRestControllerTest {

	
	@Autowired
	PersonneController pc;
	
	
	@MockBean
	PersonneManager pm;
	
	@Autowired
    private MockMvc mockMvc;
	

	@Test
	public void testPersonnePasTrouvee() throws Exception {
		Optional<Personne> op = Optional.empty();
		when(pm.trouver(anyInt())).thenReturn(op);
		
		this.mockMvc.perform(get("/rs/1"))
        .andExpect(status().is4xxClientError());
 	}

	@Test
	public void testPersonneTrouvee() throws Exception {
		Optional<Personne> op = Optional.of(new Personne(1, "Legrand", "Aline", 35));
		when(pm.trouver(anyInt())).thenReturn(op);
		
		this.mockMvc.perform(get("/rs/2"))
        .andExpect(status().isOk())
       	.andExpect(content().string(containsString("Legrand")));
 	}

}
