package com.blog.alc.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id ;
    private String titre;
    private String auteur;
    @Column(columnDefinition = "TEXT")
    private String contenu;
    @Column(updatable = false)
    private LocalDate dateCreation;

    public Article() {
    }

    public Article(LocalDate dateCreation, String contenu, String auteur, Long id, String titre) {
        this.dateCreation = dateCreation;
        this.contenu = contenu;
        this.auteur = auteur;
        this.id = id;
        this.titre = titre;
    }

    @PrePersist
    public void prePersist() {
        dateCreation = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }
}
