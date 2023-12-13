package com.example.eris_projet.entities;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Entity
@Table(name = "thematique")
public class Thematique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom_thematique;

    public Thematique() {
    }

    public Thematique(int id, String nom_thematique) {
        this.id = id;
        this.nom_thematique = nom_thematique;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_thematique() {
        return nom_thematique;
    }

    public void setNom_thematique(String nom_thematique) {
        this.nom_thematique = nom_thematique;
    }
}