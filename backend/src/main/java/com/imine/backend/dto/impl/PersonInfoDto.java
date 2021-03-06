package com.imine.backend.dto.impl;

import com.imine.backend.dto.Dto;

import java.util.Date;

/**
 * Created by dev on 2015/6/25.
 */
public class PersonInfoDTO implements Dto {
   private int weight;
   private int pushUp;
   private int sitUp;
   private int squad;
   private Date timestamp;

   public int getWeight() {
      return weight;
   }

   public void setWeight(int weight) {
      this.weight = weight;
   }

   public int getPushUp() {
      return pushUp;
   }

   public void setPushUp(int pushUp) {
      this.pushUp = pushUp;
   }

   public int getSitUp() {
      return sitUp;
   }

   public void setSitUp(int sitUp) {
      this.sitUp = sitUp;
   }

   public int getSquad() {
      return squad;
   }

   public void setSquad(int squad) {
      this.squad = squad;
   }

   public Date getTimestamp() {
      if (this.timestamp != null)
         return new Date(this.timestamp.getTime());
      else
         return null;
   }

   public void setTimestamp(Date timestamp) {
      if (timestamp != null)
         this.timestamp = new Date(timestamp.getTime());
      else
         this.timestamp = null;
   }
}
