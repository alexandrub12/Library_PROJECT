package com.librarie.proiectlibrarie.entities;

import com.librarie.proiectlibrarie.entities.Autor;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Basic
    private String bookName;
    private int nrPagini;

    public int getNrPagini() {
        return nrPagini;
    }

    public void setNrPagini(int nrPagini) {
        this.nrPagini = nrPagini;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @OneToMany(mappedBy = "book")
    private List<Imprumutare> imprumuturi;


    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public List<Imprumutare> getImprumuturi() {
        return imprumuturi;
    }

    public void setImprumuturi(List<Imprumutare> imprumuturi) {
        this.imprumuturi = imprumuturi;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}