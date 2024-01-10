package com.librarie.proiectlibrarie.entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Imprumutare> imprumuturi;
    @Id
    private Long id;

    public List<Imprumutare> getImprumuturi() {
        return imprumuturi;
    }

    public void setImprumuturi(List<Imprumutare> imprumuturi) {
        this.imprumuturi = imprumuturi;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}