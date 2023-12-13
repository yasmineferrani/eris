package com.example.eris_projet.service;

import com.example.eris_projet.entities.*;
import com.example.eris_projet.repos.ActiviteRepository;
import com.example.eris_projet.repos.LocalisationRepository;
import com.example.eris_projet.repos.ThematiqueRepository;
import com.example.eris_projet.repos.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ActiviteService {
    @Autowired
    private VilleRepository repoVille;
    @Autowired
    private ActiviteRepository repoActivite;

    @Autowired
    private LocalisationRepository repoLoc;
    @Autowired
    private ThematiqueRepository repoThematique;
    public List<Ville> listAllVilles() {
        return (List<Ville>) repoVille.findAll();
    }

    public List<Activite> listAllActivite() {
        return (List<Activite>) repoActivite.findAll();
    }

    public List<Localisation> listAllLocalisation() {
        return (List<Localisation>) repoLoc.findAll();
    }

    public List<Thematique> listAllThematique() {
        return (List<Thematique>) repoThematique.findAll();
    }

    public List<Ville> rechercherVille(String nomVille){
        if(nomVille != null){
            return repoVille.findAll(nomVille);
        }
        return null;
    }

    public List<Activite> listActiviteByVille(Integer id) {
        List<Activite> listActiviteByVille = new ArrayList<>();
        Ville ville = repoVille.findById(id).orElse(null);
        List<Activite>  listeActivite = repoActivite.findAll();
        for (Activite activite : listeActivite) {
            if(activite.getVille()==ville){
                listActiviteByVille.add(activite);
            }
        }

        return listActiviteByVille;
    }

    public Activite findById(int id) {
        return repoActivite.findById(id).orElse(null);
    }
    public Activite save(Activite activite) {


        return repoActivite.save(activite);
    }
    public void delete(Integer id)  {
        Optional<Activite> result = repoActivite.findById(id);
        repoActivite.deleteById(id);
    }
}
