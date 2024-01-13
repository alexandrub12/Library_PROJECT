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

    public void createBook(String bookName, String pagesNumber, Long autorId) {

        LOG.info("createBook");

        Book book = new Book();
        book.setBookName(bookName);
        book.setNrPagini(Integer.parseInt(pagesNumber));

        Autor autor = entityManager.find(Autor.class,autorId);
        autor.getBooks().add(book);
        book.setAutor(autor);

        entityManager.persist(book);
    }

    public BookDto findById(Long id){

        Book book = entityManager.find(Book.class, id);
        return new BookDto(id, book.getBookName(), book.getNrPagini(), book.getImprumuturi(),book.getAutor());
    }

    public void updatedBook(Long bookId, String bookName, String pagesNumber, Long autorId) {

        LOG.info("updateBook");

        Book book = entityManager.find(Book.class, bookId);
        book.setBookName(bookName);
        book.setNrPagini(Integer.parseInt(pagesNumber));

        Autor oldAutor=book.getAutor();
        oldAutor.getBooks().remove(book);

        Autor autor = entityManager.find(Autor.class,autorId);
        autor.getBooks().add(book);
        book.setAutor(autor);

    }

    public void deleteBooksByIds(List<Long> bookIds) {

        LOG.info("deleteBooksByIds");

        for (Long bookId : bookIds) {
            Book car= entityManager.find(Book.class, bookId);
            entityManager.remove(car);
        }
    }

}