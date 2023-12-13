package com.example.eris_projet.service;

import com.example.eris_projet.entities.Client;
import com.example.eris_projet.entities.ClientNotFoundException;
import com.example.eris_projet.entities.Inscription_Activite;
import com.example.eris_projet.repos.ClientRepository;
import com.example.eris_projet.repos.Inscription_ActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repo;
    @Autowired
    private Inscription_ActiviteRepository repoIns;

    public Client save(Client client){
        return repo.save(client);
    }

    public Inscription_Activite save(Inscription_Activite inscriptionActivite){
        return repoIns.save(inscriptionActivite);
    }

    public List<Inscription_Activite> listInscriptionsByClient(Integer id){
        List<Inscription_Activite> listInscriptionsByClient = new ArrayList<>();
        Client client = repo.findById(id).orElse(null);
        List<Inscription_Activite> listInscriptions = (List<Inscription_Activite>) repoIns.findAll();
        for(Inscription_Activite inscriptionActivite : listInscriptions){
            if(inscriptionActivite.getInfo_client() == client){
                listInscriptionsByClient.add(inscriptionActivite);
            }
        }
        return listInscriptionsByClient;
    }

    public Client getByEmailPassword(String email, String password) throws ClientNotFoundException {
        try {
            Client client = repo.getClientByEmailAndPassword(email, password);
            return client;
        } catch (NoSuchElementException exception){
            throw new ClientNotFoundException("On ne peut pas trouver le client");
        }
    }

    public Inscription_Activite get(Integer id)  {
        Optional<Inscription_Activite> result = repoIns.findById(id);
            return result.get();
    }


    public void deleteIns(Integer id)  {
        Optional<Inscription_Activite> result = repoIns.findById(id);
        repoIns.deleteById(id);
    }


}
