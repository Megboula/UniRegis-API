package com.project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inscriptions")
public class Inscription {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false)
    private String matricule;        // ← ajouté

    @Enumerated(EnumType.STRING)
    private Statut statut;

    @Version 
    private Long version; 

    public Inscription() {}

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMatricule() { return matricule; }      // ← ajouté
    public void setMatricule(String m) { this.matricule = m; } // ← ajouté

    public Statut getStatut() { return statut; }
    public void setStatut(Statut statut) { this.statut = statut; }
}