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

   // 拿到EntityManager
   public EntityManager getEntityManager() {
      EntityManager em = null;
      try {
         EntityManagerFactory emf =
               Persistence.createEntityManagerFactory("lushuifa");
         em = emf.createEntityManager();
      } catch (Exception e) {
         System.out.println("获取EntityManager失败了！原因如下：" + e);
      }
      return em;
   }

   public long createEntity(User user) {
      System.out.println(this.entityManager);
      try {
         this.entityManager.getTransaction().begin();

         this.entityManager.persist(user);
         this.entityManager.getTransaction().commit();
         System.out.println("添加用户成功！");
      } catch (Exception e) {
         System.out.println("添加用户失败，原因如下：");
         e.printStackTrace();
      }
      return 0;
   }

   public User getEntity(long id) {
      User user = null;
      try {
         user = this.entityManager.find(User.class, id);
      } catch (Exception e) {
         System.out.println("查询用户有误，原因如下：" + e);
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
