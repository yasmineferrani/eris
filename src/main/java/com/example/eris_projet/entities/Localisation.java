package com.example.eris_projet.entities;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Entity
@Table(name = "localisation")
public class Localisation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_localisation;
    private int numero_adresse;
    private String rue;
    private String ville;
    private String code_postal;

    public Localisation() {
    }

    public Localisation(int id_localisation, int numero_adresse, String rue, String ville, String code_postal) {
        this.id_localisation = id_localisation;
        this.numero_adresse = numero_adresse;
        this.rue = rue;
        this.ville = ville;
        this.code_postal = code_postal;
    }

    public int getId_localisation() {
        return id_localisation;
    }

    public void setId_localisation(int id_localisation) {
        this.id_localisation = id_localisation;
    }

    public int getNumero_adresse() {
        return numero_adresse;
    }

    public void setNumero_adresse(int numero_adresse) {
        this.numero_adresse = numero_adresse;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }
}