package com.librarie.proiectlibrarie.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Imprumutare {
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_id")
    private Book book;

    private Date dataImprumut;
    private Date dataReturnareMaxima;

    public Date getDataImprumut() {
        return dataImprumut;
    }

    public void setDataImprumut(Date dataImprumut) {
        this.dataImprumut = dataImprumut;
    }

    public Date getDataReturnareMaxima() {
        return dataReturnareMaxima;
    }

    public void setDataReturnareMaxima(Date dataReturnareMaxima) {
        this.dataReturnareMaxima = dataReturnareMaxima;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}