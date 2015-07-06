package com.imine.backend.dao.impl;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.imine.backend.dao.PersonInfoDAO;
import com.imine.backend.dto.impl.PersonInfoDTO;
import com.imine.backend.model.PersonInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.io.Reader;

/**
 * Author: Ethan(Baiyp)<br/>
 * Date: 2015/7/1.<br/>
 * E-mail: baiyp@xiatekeji.com
 */
public class PersonInfoDAOImpl implements PersonInfoDAO {
   private EntityManager entityManager = getEntityManager();

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

   public long createEntity(PersonInfo personInfo) {
      return 0;
   }

   public PersonInfo getEntity(long id) {

      return null;
   }

   public long deleteEntity(long id) {
      return 0;
   }

   public long updateEntity(PersonInfo personInfo) {
      return 0;
   }
}
