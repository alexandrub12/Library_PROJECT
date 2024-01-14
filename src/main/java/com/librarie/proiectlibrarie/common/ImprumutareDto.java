package com.librarie.proiectlibrarie.common;

import com.librarie.proiectlibrarie.entities.Book;
import com.librarie.proiectlibrarie.entities.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class ImprumutareDto {

    private Long id;
    private User user;
    private Book book;
    private Date dataImprumut;
    private Date dataReturnareMaxima;

    public ImprumutareDto(Long id, User user, Book book, Date dataImprumut, Date dataReturnareMaxima) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.dataImprumut = dataImprumut;
        this.dataReturnareMaxima = dataReturnareMaxima;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}