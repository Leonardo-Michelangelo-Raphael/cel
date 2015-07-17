package com.imine.backend.dao;

import com.imine.backend.dao.exception.RestEntityNotExistException;
import com.imine.backend.model.User;

/**
 * Author: Ethan(Baiyp) <br />
 * Date: 2015/7/6. <br />
 * E-mail: baiyp@xiatekeji.com
 */
public interface UserDAO extends DAO<User>{
   User getUserByUsername(String username) throws RestEntityNotExistException;

   /**
    * User login in.
    * 
    * @param u
    */
   void signIn(User u);

   /**
    * User sign up a new account.
    * 
    * @param u
    */
   void sighUp(User u);
}
