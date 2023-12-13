package com.example.eris_projet.repos;

import com.example.eris_projet.entities.Thematique;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThematiqueRepository extends CrudRepository<Thematique, Integer> {
}
