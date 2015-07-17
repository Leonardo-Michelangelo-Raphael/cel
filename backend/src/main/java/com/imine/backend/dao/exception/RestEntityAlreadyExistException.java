package com.imine.backend.dao.exception;

/**
 * Author: Ethan(Baiyp) <br />
 * Date: 2015/7/17. <br />
 * E-mail: baiyp@xiatekeji.com
 */
public class RestEntityAlreadyExistException extends RestException {
   public RestEntityAlreadyExistException(String msg, Throwable ex) {
      super(String.format("Entity: %s already exists.", msg), ex);
   }

   public RestEntityAlreadyExistException(String msg, Class clazz) {
      super(String.format("Entity %s: %s already exists.", clazz.toString(), msg));
   }

   public RestEntityAlreadyExistException(String msg) {
      super(String.format("Entity: %s already exists.", msg));
   }
}
