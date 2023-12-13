package com.example.eris_projet.repos;

import com.example.eris_projet.entities.Inscription_Activite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Inscription_ActiviteRepository extends CrudRepository<Inscription_Activite, Integer> {
}
