package com.imine.backend.dao.impl;

import com.imine.backend.dao.AbstractPersistenceEngine;
import com.imine.backend.dao.UserDAO;
import com.imine.backend.dao.exception.RestEntityAlreadyExistException;
import com.imine.backend.dao.exception.RestEntityNotExistException;
import com.imine.backend.dao.exception.RestException;
import com.imine.backend.model.User;

import javax.persistence.NoResultException;
import javax.persistence.Query;


/**
 * Author: Ethan(Baiyp) <br />
 * Date: 2015/7/6. <br />
 * E-mail: baiyp@xiatekeji.com
 */
public class UserDAOImpl extends AbstractPersistenceEngine implements UserDAO {
   public long createEntity(User user) throws RestException {
      try {
         getUserByUsername(user.getUsername());
         throw new RestEntityAlreadyExistException(user.getUsername(), User.class);
      } catch (RestEntityNotExistException e) {
         save(user);
         return getUserByUsername(user.getUsername()).getUserId();
      }
   }

   public User getEntity(long id) throws RestException {
      User user = getEntityManager().find(User.class, id);
      if (user == null) {
         throw new RestEntityNotExistException(String.valueOf(id), User.class);
      }
      return user;
   }

   public long deleteEntity(long id) throws RestException {
      User user = getEntity(id);
      delete(user);
      return id;
   }

   public long updateEntity(User user) {
      return 0;
   }

   /**
    * Clean up all the data in database. Which is used for testing.
    */
   public void cleanUp() {
      getEntityManager().getTransaction().begin();
      getEntityManager().createNativeQuery("delete from User").executeUpdate();
      getEntityManager().getTransaction().commit();
   }

   public User getUserByUsername(String username)
         throws RestEntityNotExistException {
      Query query =
            getEntityManager().createQuery(
                  "select u from User as u where u.username = :username",
                  User.class).setParameter("username", username);
      try {
         return (User) query.getSingleResult();
      } catch (NoResultException ex) {
         throw new RestEntityNotExistException(username, ex);
      }
   }

   /**
    * User login in.
    *
    * @param u, which is the target user.
    */
   public void signIn(User u) {

   }

   /**
    * User sign up a new account.
    *
    * @param u, which is the target user.
    */
   public void sighUp(User u) {

   }
}
