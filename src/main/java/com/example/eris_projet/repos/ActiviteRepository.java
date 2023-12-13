package com.example.eris_projet.repos;

import com.example.eris_projet.entities.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Integer> {

}
