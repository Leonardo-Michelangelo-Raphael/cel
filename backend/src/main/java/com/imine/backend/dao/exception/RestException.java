package com.imine.backend.dao.exception;

/**
 * Author: Ethan(Baiyp) <br />
 * Date: 2015/7/17. <br />
 * E-mail: baiyp@xiatekeji.com
 */
public class RestException extends Exception {
   private int code;

   public RestException(String msg) {
      super(msg);
      this.code = 500;
   }

   public RestException(String msg, Throwable ex) {
      super(msg, ex);
      this.code = 500;
   }

   public int getCode() {
      return code;
   }

   public void setCode(int code) {
      this.code = code;
   }
}
