package com.librarie.proiectlibrarie.ejb;

import com.librarie.proiectlibrarie.servlets.Books;
import com.librarie.proiectlibrarie.common.BookDto;
import com.librarie.proiectlibrarie.entities.Autor;
import com.librarie.proiectlibrarie.entities.Book;
import com.librarie.proiectlibrarie.entities.Imprumutare;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class BookBean {

    private static final Logger LOG = Logger.getLogger(BookBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;


    public List<BookDto> findAllBooks()
    {
        LOG.info("findAllBooks");
        try
        {
            TypedQuery<Book> typedQuery = entityManager.createQuery("SELECT b FROM Book b",Book.class);
            List<Book> books = typedQuery.getResultList();
            return copyBooksToDto(books);
        }
        catch (Exception ex)
        {
            throw new EJBException(ex);
        }
    }

    private List<BookDto> copyBooksToDto(List<Book> books) {
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : books) {
            List<Imprumutare> imprumuturi = book.getImprumuturi(); // Assuming Book entity has a getter for Imprumutare list
            Autor autor = book.getAutor(); // Assuming Book entity has a getter for Autor

            BookDto bookDto = new BookDto(
                    book.getId(),
                    book.getBookName(),
                    book.getNrPagini(),
                    imprumuturi,
                    autor
            );
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

}