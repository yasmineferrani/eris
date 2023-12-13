package com.example.eris_projet.entities;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "inscription_activite")
public class Inscription_Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_inscription_activite;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client id_client;
    @ManyToOne(optional = false)
    @JoinColumn(name = "activite_id", nullable = false)
    private Activite activite;

    public Inscription_Activite() {
    }

    public Inscription_Activite(int id_inscription_activite, Date date,
                                Client info_client, Activite activite) {
        this.id_inscription_activite = id_inscription_activite;
        this.date = date;
        this.id_client = id_client;
        this.activite = activite;
    }

    public int getId_inscription_activite() {
        return id_inscription_activite;
    }

    public void setId_inscription_activite(int id_inscription_activite) {
        this.id_inscription_activite = id_inscription_activite;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getInfo_client() {
        return id_client;
    }

    public void setInfo_client(Client id_client) {
        this.id_client = id_client;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }
}