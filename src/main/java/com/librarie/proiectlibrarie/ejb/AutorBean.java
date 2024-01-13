package com.librarie.proiectlibrarie.ejb;

import com.librarie.proiectlibrarie.common.AutorDto;
import com.librarie.proiectlibrarie.common.BookDto;
import com.librarie.proiectlibrarie.entities.Autor;
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
public class AutorBean {
    private static final Logger LOG = Logger.getLogger(AutorBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;


    public List<AutorDto> findAllAutors()
    {
        LOG.info("findAllAutors");
        try
        {
            TypedQuery<Autor> typedQuery = entityManager.createQuery("SELECT a FROM Autor a",Autor.class);
            List<Autor> Autors = typedQuery.getResultList();
            return copyAutorsToDto(Autors);
        }
        catch (Exception ex)
        {
            throw new EJBException(ex);
        }
    }

    private List<AutorDto> copyAutorsToDto(List<Autor> Autors) {
        List<AutorDto> AutorDtos = new ArrayList<>();
        for (Autor Autor : Autors) {
            List<Book> books = Autor.getBooks();

            AutorDto AutorDto = new AutorDto(
                    Autor.getId(),
                    Autor.getNumeAutor(),
                    Autor.getPrenumeAutor(),
                    books
            );
            AutorDtos.add(AutorDto);
        }
        return AutorDtos;
    }
    public void createAutor(String numeAutor, String prenumeAutor) {

        LOG.info("createAutor");

        Autor autor = new Autor();
        autor.setNumeAutor(numeAutor);
        autor.setPrenumeAutor(prenumeAutor);


        entityManager.persist(autor);
    }

    public AutorDto findById(Long id){

        Autor autor = entityManager.find(Autor.class, id);
        return new AutorDto(id, autor.getNumeAutor(), autor.getPrenumeAutor(), autor.getBooks());
    }

    public void updatedAutor(Long autorId, String numeAutor, String prenumeAutor) {

        LOG.info("updateAutor");

        Autor autor = entityManager.find(Autor.class, autorId);
        autor.setNumeAutor(numeAutor);
        autor.setPrenumeAutor(prenumeAutor);

    }

    public void deleteAutorsByIds(List<Long> autorsIds) {

        LOG.info("deleteAutorsByIds");

        for (Long autorId : autorsIds) {
            Autor autor= entityManager.find(Autor.class, autorId);
            entityManager.remove(autor);
        }
    }

}