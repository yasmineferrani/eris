package com.example.eris_projet.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ville")
public class Ville{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom_ville;
    private String photo_ville;

    public Ville() {
    }

    public Ville(int id, String nom_ville, String photo_ville) {
        this.id = id;
        this.nom_ville = nom_ville;
        this.photo_ville = photo_ville;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_ville() {
        return nom_ville;
    }

    public void setNom_ville(String nom_ville) {
        this.nom_ville = nom_ville;
    }

    public String getPhoto_ville() {
        return photo_ville;
    }

    public void setPhoto_ville(String photo_ville) {
        this.photo_ville = photo_ville;
    }
}