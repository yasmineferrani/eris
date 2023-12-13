package com.example.eris_projet.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import java.util.Date;


@Entity
@Table(name = "activite")
public class Activite {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_activite;
    private String nom_activite;
    private String photo_activite;
    private int cout;
    @Temporal(TemporalType.DATE)
    private Date date_debut;
    @Temporal(TemporalType.DATE)
    private Date date_fin;
    @ManyToOne(optional = false)
    @JoinColumn(name = "localisation_id", nullable = false)
    private Localisation localisation;
    @ManyToOne(optional = false)
    @JoinColumn(name = "ville_id", nullable = false)
    private Ville ville;
    @ManyToOne(optional = false)
    @JoinColumn(name = "thematique_id", nullable = false)
    private Thematique thematique;
    public Activite() {
    }

    public Activite(String nom_activite, String photo_activite) {
        this.nom_activite = nom_activite;
        this.photo_activite = photo_activite;
    }

    public Activite(int id_activite, String nom_activite, String photo_activite, int cout,
                    Date date_debut, Date date_fin, Localisation localisation, Ville ville, Thematique thematique) {
        this.id_activite = id_activite;
        this.nom_activite = nom_activite;
        this.photo_activite = photo_activite;
        this.cout = cout;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.localisation = localisation;
        this.ville= ville;
        this.thematique = thematique;
    }

    public int getId_activite() {
        return id_activite;
    }

    public void setId_activite(int id_activite) {
        this.id_activite = id_activite;
    }

    public String getNom_activite() {
        return nom_activite;
    }

    public void setNom_activite(String nom_activite) {
        this.nom_activite = nom_activite;
    }

    public String getPhoto_activite() {
        return photo_activite;
    }

    public void setPhoto_activite(String photo_activite) {
        this.photo_activite = photo_activite;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Thematique getThematique() {
        return thematique;
    }

    public void setThematique(Thematique thematique) {
        this.thematique = thematique;
    }

}