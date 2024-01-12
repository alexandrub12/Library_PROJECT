package com.librarie.proiectlibrarie.common;

import com.librarie.proiectlibrarie.entities.Imprumutare;

import java.util.List;

public class UserDto {

    private Long id;
    private String username;
    private String email;
    private String password;
    private List<Imprumutare> imprumuturi;

    public UserDto(Long id, String username, String email, String password, List<Imprumutare> imprumuturi) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.imprumuturi = imprumuturi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<Imprumutare> getImprumuturi() {
        return imprumuturi;
    }

    public void setImprumuturi(List<Imprumutare> imprumuturi) {
        this.imprumuturi = imprumuturi;
    }
}