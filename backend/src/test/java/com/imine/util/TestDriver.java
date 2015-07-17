package com.imine.util;

import java.util.Random;

/**
 * Author: Ethan(Baiyp) <br />
 * Date: 2015/7/17. <br />
 * E-mail: baiyp@xiatekeji.com
 */
public final class TestDriver {
   private static final char[] symbols;

   static {
      StringBuilder tmp = new StringBuilder();
      for (char ch = '0'; ch <= '9'; ++ch)
         tmp.append(ch);
      for (char ch = 'a'; ch <= 'z'; ++ch)
         tmp.append(ch);
      symbols = tmp.toString().toCharArray();
   }

   private final static Random random = new Random();

   public static String randomString(int length) {
      if (length < 1)
         throw new IllegalArgumentException("length < 1: " + length);
      char[] buf = new char[length];
      return nextString(buf);
   }

   private static String nextString(char[] buf) {
      for (int idx = 0; idx < buf.length; ++idx)
         buf[idx] = symbols[random.nextInt(symbols.length)];
      return new String(buf);
   }
}
