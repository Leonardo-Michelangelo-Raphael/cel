package com.imine.backend.dao.impl;

import com.imine.backend.dao.UserDAO;
import com.imine.backend.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Author: Ethan(Baiyp) <br />
 * Date: 2015/7/6. <br />
 * E-mail: baiyp@xiatekeji.com
 */
public class UserDAOImplTest {
   private UserDAO dao;

   @BeforeClass
   public void setUp() {
      dao = new UserDAOImpl();
      dao.cleanUp();
   }

   @Test
   public void testCreate() {
      User u = new User();
      u.setUsername("TestUsername");
      u.setPassword("TestPassword");
      dao.createEntity(u);
   }

   @Test
   public void testGetUserByUsername() {
      String username = "EXIST_USERNAME";
      User u = new User();
      u.setUsername(username);
      u.setPassword("");

      dao.createEntity(u);

      u = dao.getUserByUsername(username);

      Assert.assertEquals(u.getUsername(), username);
      Assert.assertTrue(u.getUserId() != 0 );
   }
}
