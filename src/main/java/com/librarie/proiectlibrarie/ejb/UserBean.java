package com.librarie.proiectlibrarie.ejb;


import com.librarie.proiectlibrarie.common.UserDto;
import com.librarie.proiectlibrarie.entities.Imprumutare;
import com.librarie.proiectlibrarie.entities.User;
import com.librarie.proiectlibrarie.entities.UserGroup;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UserBean {

    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    PasswordBean passwordBean;

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

    public UserDto findUserByUsername(String username)
    {
        try
        {
            TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u where u.username=:username",User.class);
            typedQuery.setParameter("username", username);


            User user = typedQuery.getSingleResult();
            return new UserDto(user.getId(),user.getUsername(),user.getEmail(),user.getPassword(),user.getImprumuturi());
        }
        catch (Exception ex)
        {
            throw new EJBException(ex);
        }
    }


    public void createUser(String username, String email, String password, Collection<String> groups) {
        LOG.info("createUser");
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(passwordBean.convertToSha256(password));
        entityManager.persist(newUser);
        assignGroupsToUser(username, groups);
    }
    private void assignGroupsToUser(String username, Collection<String> groups) {
        LOG.info("assignGroupsToUser");
        for (String group : groups) {
            UserGroup userGroup = new UserGroup();
            userGroup.setUsername(username);
            userGroup.setUserGroup(group);
            entityManager.persist(userGroup);
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