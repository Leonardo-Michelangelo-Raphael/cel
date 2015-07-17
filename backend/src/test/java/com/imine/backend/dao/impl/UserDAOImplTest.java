package com.imine.backend.dao.impl;

import com.imine.backend.dao.UserDAO;
import com.imine.backend.dao.exception.RestEntityNotExistException;
import com.imine.backend.dao.exception.RestException;
import com.imine.backend.model.User;
import com.imine.util.TestDriver;
import org.springframework.test.annotation.ExpectedException;
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
   public void testCreate() throws RestException {
      User u = new User();
      u.setUsername("TestUsername");
      u.setPassword("TestPassword");
      dao.createEntity(u);
   }

   @Test(expectedExceptions = RestEntityNotExistException.class)
   public void testGetUserByUsername() throws RestException {
      String usernameExist = "EXIST_USERNAME";
      User u = new User();
      u.setUsername(usernameExist);
      u.setPassword("");

      dao.createEntity(u);

      u = dao.getUserByUsername(usernameExist);

      Assert.assertEquals(u.getUsername(), usernameExist);
      Assert.assertTrue(u.getUserId() != 0);

      String usernameNotExist = "NOT_EXIST_USERNAME";

      u = dao.getUserByUsername(usernameNotExist);
   }

   @Test(expectedExceptions = RestEntityNotExistException.class)
   public void testGetNotExistUser() throws RestException {
      User u = new User();
      u.setUsername(TestDriver.randomString(19));
      u.setPassword(TestDriver.randomString(19));
      long uid = dao.createEntity(u);

      dao.deleteEntity(uid);
      dao.getEntity(uid);
   }
}
