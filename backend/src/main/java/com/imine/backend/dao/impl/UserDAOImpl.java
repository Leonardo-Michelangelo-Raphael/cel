package com.imine.backend.dao.impl;

import com.imine.backend.dao.UserDAO;
import com.imine.backend.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Author: Ethan(Baiyp) <br />
 * Date: 2015/7/6. <br />
 * E-mail: baiyp@xiatekeji.com
 */
public class UserDAOImpl implements UserDAO {
   private EntityManager entityManager = getEntityManager();

   public EntityManager getEntityManager() {
      EntityManager em = null;
      try {
         EntityManagerFactory emf =
               Persistence.createEntityManagerFactory("user-system");
         em = emf.createEntityManager();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return em;
   }

   public long createEntity(User user) {
      System.out.println(this.entityManager);
      try {
         this.entityManager.getTransaction().begin();

         this.entityManager.persist(user);
         this.entityManager.getTransaction().commit();
         System.out.println("Add User Successfully");
      } catch (Exception e) {
         System.out.println("����û�ʧ�ܣ�ԭ�����£�");
         e.printStackTrace();
      }
      return 0;
   }

   public User getEntity(long id) {
      User user = null;
      try {
         user = this.entityManager.find(User.class, id);
      } catch (Exception e) {
         System.out.println("��ѯ�û�����ԭ�����£�" + e);
      }
      return user;
   }

   public long deleteEntity(long id) {
      return 0;
   }

   public long updateEntity(User user) {
      return 0;
   }
}
