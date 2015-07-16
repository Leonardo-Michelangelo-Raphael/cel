package com.imine.backend.dao.impl;

import com.imine.backend.dao.UserDAO;
import com.imine.backend.model.User;
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
   }

   @Test
   public void testCreate() {
      User u = new User();
      u.setUsername("TestUsername");
      u.setPassword("TestPassword");
      dao.createEntity(u);
   }
}
