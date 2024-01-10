package com.librarie.proiectlibrarie.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Autor {
    @Id
    @GeneratedValue
    private Long id;

    private String numeAutor;
    private String prenumeAutor;
    @OneToMany(mappedBy = "autor")
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getNumeAutor() {
        return numeAutor;
    }

    public void setNumeAutor(String numeAutor) {
        this.numeAutor = numeAutor;
    }

    public String getPrenumeAutor() {
        return prenumeAutor;
    }

    public void setPrenumeAutor(String prenumeAutor) {
        this.prenumeAutor = prenumeAutor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}