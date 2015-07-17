package com.imine.backend.dao;

import com.imine.backend.model.Entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Author: Ethan(Baiyp) <br />
 * Date: 2015/7/16. <br />
 * E-mail: baiyp@xiatekeji.com
 */
public abstract class AbstractPersistenceEngine {
   private EntityManager entityManager = setEntityManager();

   public EntityManager getEntityManager() {
      return entityManager;
   }

   private EntityManager setEntityManager() {
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

   public void save(Entity entity) {
      this.entityManager.getTransaction().begin();
      this.entityManager.persist(entity);
      this.entityManager.getTransaction().commit();
   }

   public void update(Entity entity) {
      this.entityManager.getTransaction().begin();
      this.entityManager.merge(entity);
      this.entityManager.getTransaction().commit();
   }

   public void delete(Entity entity) {
      this.entityManager.getTransaction().begin();
      this.entityManager.remove(entity);
      this.entityManager.getTransaction().commit();
   }
}
