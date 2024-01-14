package com.librarie.proiectlibrarie.common;

import com.librarie.proiectlibrarie.entities.Autor;
import com.librarie.proiectlibrarie.entities.Imprumutare;

import java.util.List;

public class BookDto {

    private Long id;
    private String bookName;
    private int nrPagini;
    private List<Imprumutare> imprumuturi;
    private Autor autor;
    private int cantitate;

    public BookDto(Long id, String bookName, int nrPagini, List<Imprumutare> imprumuturi, Autor autor,int cantitate) {
        this.id = id;
        this.bookName = bookName;
        this.nrPagini = nrPagini;
        this.imprumuturi = imprumuturi;
        this.autor = autor;
        this.cantitate = cantitate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNrPagini() {
        return nrPagini;
    }

    public void setNrPagini(int nrPagini) {
        this.nrPagini = nrPagini;
    }

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


    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }


}