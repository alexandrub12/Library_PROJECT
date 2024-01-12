package com.librarie.proiectlibrarie.common;

import com.librarie.proiectlibrarie.entities.Book;
import jakarta.persistence.OneToMany;

import java.util.List;

public class AutorDto {

    private Long id;
    private String numeAutor;
    private String prenumeAutor;
    private List<Book> books;

    public AutorDto(Long id, String numeAutor, String prenumeAutor, List<Book> books) {
        this.id = id;
        this.numeAutor = numeAutor;
        this.prenumeAutor = prenumeAutor;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
