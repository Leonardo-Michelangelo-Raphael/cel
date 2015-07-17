package com.imine.backend.dao.exception;

/**
 * Author: Ethan(Baiyp) <br />
 * Date: 2015/7/17. <br />
 * E-mail: baiyp@xiatekeji.com
 */
public class RestEntityNotExistException extends RestException {
   public RestEntityNotExistException(String msg) {
      super(String.format("Entity: %s does not exist!", msg));
   }

   public RestEntityNotExistException(String msg, Throwable ex) {
      super(String.format("Entity: %s does not exist!", msg), ex);
   }

   public RestEntityNotExistException(String msg, Class tClass) {
      super(String.format("Entity %s: %s does not exist", tClass.toString(),
            msg));
   }
}
