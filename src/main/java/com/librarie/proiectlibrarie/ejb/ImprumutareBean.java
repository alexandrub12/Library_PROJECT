package com.librarie.proiectlibrarie.ejb;

import com.librarie.proiectlibrarie.common.BookDto;
import com.librarie.proiectlibrarie.common.ImprumutareDto;
import com.librarie.proiectlibrarie.entities.Autor;
import com.librarie.proiectlibrarie.entities.Book;
import com.librarie.proiectlibrarie.entities.Imprumutare;
import com.librarie.proiectlibrarie.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class ImprumutareBean {
    private static final Logger LOG = Logger.getLogger(ImprumutareBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;


    public List<ImprumutareDto> findAllImprumutariByUserId(long userId)
    {
        LOG.info("findAllImprumutari");
        try
        {
            TypedQuery<Imprumutare> typedQuery = entityManager.createQuery("SELECT i FROM Imprumutare i where i.user.id=:id",Imprumutare.class);
            typedQuery.setParameter("id", userId);



            List<Imprumutare> imprumutari = typedQuery.getResultList();
            return copyImprumutariToDto(imprumutari);
        }
        catch (Exception ex)
        {
            throw new EJBException(ex);
        }
    }

    private List<ImprumutareDto> copyImprumutariToDto(List<Imprumutare> imprumutari) {
        List<ImprumutareDto> imprumutareDtos = new ArrayList<>();
        for (Imprumutare imprumutare : imprumutari) {

            ImprumutareDto imprumutareDto = new ImprumutareDto(
                    imprumutare.getId(),
                    imprumutare.getUser(),
                    imprumutare.getBook(),
                    imprumutare.getDataImprumut(),
                    imprumutare.getDataReturnareMaxima()
            );
            imprumutareDtos.add(imprumutareDto);
        }
        return imprumutareDtos;
    }

    public void createImprumutare(Long userId, Long bookId, Date dataImprumut, Date dataReturnare) {

        LOG.info("createImprumutare");

        Imprumutare imprumutare = new Imprumutare();

        User user = entityManager.find(User.class,userId);
        user.getImprumuturi().add(imprumutare);
        imprumutare.setUser(user);

        Book book = entityManager.find(Book.class,bookId);
        book.getImprumuturi().add(imprumutare);
        book.setCantitate(book.getCantitate()-1);
        imprumutare.setBook(book);

        imprumutare.setDataImprumut(dataImprumut);
        imprumutare.setDataReturnareMaxima(dataReturnare);



        entityManager.persist(imprumutare);
    }

    public ImprumutareDto findById(Long id){

        Imprumutare imprumutare = entityManager.find(Imprumutare.class, id);
        return new ImprumutareDto(id, imprumutare.getUser(), imprumutare.getBook(), imprumutare.getDataImprumut(),imprumutare.getDataReturnareMaxima());
    }

    public void updateImprumutare(Long imprumutareId, Date dataImprumut, Date dataReturnare) {

        LOG.info("updateImprumutare");

        Imprumutare imprumutare = entityManager.find(Imprumutare.class, imprumutareId);
        imprumutare.setDataImprumut(dataImprumut);
        imprumutare.setDataReturnareMaxima(dataReturnare);

    }

    public void deleteImprumutariByIds(List<Long> imprumutareIds) {

        LOG.info("deleteImprumutariByIds");

        for (Long imprumutareId : imprumutareIds) {
            Imprumutare imprumutare= entityManager.find(Imprumutare.class, imprumutareId);

            Book book = entityManager.find(Book.class, imprumutare.getBook().getId());
            book.setCantitate(book.getCantitate()+1);

            entityManager.remove(imprumutare);
        }
    }
}