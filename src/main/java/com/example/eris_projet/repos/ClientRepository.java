package com.example.eris_projet.repos;

import com.example.eris_projet.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
    @Query("SELECT u FROM Client u WHERE u.courriel = :courriel and u.password=:password")
    //@Param est utilisé pour lier le paramètre method au paramètre Query.
    public Client getClientByEmailAndPassword(@Param("courriel") String courriel, @Param("password") String password);


}
