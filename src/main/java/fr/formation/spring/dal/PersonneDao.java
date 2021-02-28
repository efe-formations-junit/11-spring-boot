package fr.formation.spring.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.spring.entity.Personne;

public interface PersonneDao extends JpaRepository<Personne, Integer> {

}
