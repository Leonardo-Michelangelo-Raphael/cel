package com.imine.backend.dao.impl;

import com.imine.backend.dao.AbstractPersistenceEngine;
import com.imine.backend.dao.UserDAO;
import com.imine.backend.model.User;

/**
 * Author: Ethan(Baiyp) <br />
 * Date: 2015/7/6. <br />
 * E-mail: baiyp@xiatekeji.com
 */
public class UserDAOImpl extends AbstractPersistenceEngine implements UserDAO {
   public long createEntity(User user) {
      try {
         save(user);
         System.out.println("Add User Successfully");
      } catch (Exception e) {
         e.printStackTrace();
      }
      return 0;
   }

   public User getEntity(long id) {
      User user = null;
      try {
         user = getEntityManager().find(User.class, id);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return user;
   }

   public long deleteEntity(long id) {
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

   public User getUserByUsername(String username) {
      return getEntityManager()
            .createQuery("select u from User as u where u.username = :username", User.class)
            .setParameter("username", username).getSingleResult();
   }

   /**
    * User login in.
    *
    * @param u
    */
   public void signIn(User u) {

   }

   /**
    * User sign up a new account.
    *
    * @param u
    */
   public void sighUp(User u) {

   }
}
