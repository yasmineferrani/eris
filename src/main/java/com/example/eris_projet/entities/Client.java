package com.example.eris_projet.entities;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "client")
public class Client {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int client_id;
    private String nom_client;
    private String prenom;
    private String courriel;
    private String password;
    private Boolean admin;

    public Client() {
    }

    public Client(int client_id, String nom_client, String prenom, String courriel, String password) {
        this.client_id = client_id;
        this.nom_client = nom_client;
        this.prenom = prenom;
        this.courriel = courriel;
        this.password = password;
    }

    public Client(int client_id, String nom_client, String prenom, String courriel, String password, Boolean admin) {
        this.client_id = client_id;
        this.nom_client = nom_client;
        this.prenom = prenom;
        this.courriel = courriel;
        this.password = password;
        this.admin = admin;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

}