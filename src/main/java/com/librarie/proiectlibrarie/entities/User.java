package com.librarie.proiectlibrarie.entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    private String email;
    private String password;
    @Basic
    private String username;

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Imprumutare> imprumuturi;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}