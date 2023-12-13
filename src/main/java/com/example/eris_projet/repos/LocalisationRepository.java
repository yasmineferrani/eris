package com.example.eris_projet.repos;

import com.example.eris_projet.entities.Localisation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalisationRepository extends CrudRepository<Localisation, Integer> {
}
