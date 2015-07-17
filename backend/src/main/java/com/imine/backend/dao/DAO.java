package com.imine.backend.dao;

import com.imine.backend.dao.exception.RestException;

/**
 * Author: Ethan(Baiyp) <br />
 * Date: 2015/7/6. <br />
 * E-mail: baiyp@xiatekeji.com
 */
public interface DAO<T> {
   long createEntity(T t) throws RestException;

   T getEntity(long id) throws RestException;

   long deleteEntity(long id) throws RestException;

   long updateEntity(T t) throws RestException;

   /**
    * Clean up all the data in database. Which is used for testing.
    */
   void cleanUp();
}
