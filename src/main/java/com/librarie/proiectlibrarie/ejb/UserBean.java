package com.librarie.proiectlibrarie.ejb;


import com.librarie.proiectlibrarie.common.UserDto;
import com.librarie.proiectlibrarie.entities.Imprumutare;
import com.librarie.proiectlibrarie.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UserBean {

    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;


    public List<UserDto> findAllUsers()
    {
        LOG.info("findAllUsers");
        try
        {
            TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u",User.class);
            List<User> users = typedQuery.getResultList();
            return copyUsersToDto(users);
        }
        catch (Exception ex)
        {
            throw new EJBException(ex);
        }
    }

    private List<UserDto> copyUsersToDto(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            List<Imprumutare> imprumuturi = user.getImprumuturi();

            UserDto UserDto = new UserDto(
                    user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword(),
                    imprumuturi
            );
            userDtos.add(UserDto);
        }
        return userDtos;
    }

}