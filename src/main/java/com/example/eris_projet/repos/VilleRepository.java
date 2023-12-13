package com.example.eris_projet.repos;

import com.example.eris_projet.entities.Ville;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VilleRepository extends CrudRepository<Ville, Integer> {

    @Query("SELECT u FROM Ville u WHERE u.nom_ville  LIKE %?1% ")
    public List<Ville> findAll(String nomVille);
}
