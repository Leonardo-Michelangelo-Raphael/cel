package com.imine.backend.dao;

/**
 * Author: Ethan(Baiyp) <br />
 * Date: 2015/7/6. <br />
 * E-mail: baiyp@xiatekeji.com
 */
public interface DAO<T> {
   long createEntity(T t);

   T getEntity(long id);

   long deleteEntity(long id);

   long updateEntity(T t);
}
