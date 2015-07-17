package com.imine.backend.model;

import org.apache.openjpa.persistence.DataCache;

import javax.persistence.*;

/**
 * Created by dev on 2015/6/25.
 */
@javax.persistence.Entity
@Table(name = User.TABLE_NAME)
@DataCache(enabled = false)
public class User implements Entity {
   public static final String TABLE_NAME = "USER";
   @Id
   @Column(name = "USER_ID")
   @TableGenerator(name = TABLE_NAME)
   @GeneratedValue(strategy = GenerationType.IDENTITY, generator = TABLE_NAME)
   private long userId;

   @Basic
   @Column(name = "USER_NAME")
   private String username;

   @Basic
   @Column(name = "USER_PASSWORD")
   private String password;

   public long getUserId() {
      return userId;
   }

   public void setUserId(long id) {
      this.userId = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}
