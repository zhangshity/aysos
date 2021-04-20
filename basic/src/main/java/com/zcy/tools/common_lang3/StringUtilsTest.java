package com.zcy.tools.common_lang3;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {
    public static void main(String[] args) {
        String s1 = "";
        String s2 = " ";
        String s3 = " a ";
        String s4 = "a";
        String s5 = "abc";
        String s6 = "Abc";
        String s7 = "ABC";
        String s8 = "123";
        String s9 = "abc123";



        /**
         * <p>Checks if a CharSequence is empty ("") or null.</p>
         * <pre>
         *      StringUtils.isEmpty(null)      = true
         *      StringUtils.isEmpty("")        = true
         *      StringUtils.isEmpty(" ")       = false
         *      StringUtils.isEmpty("bob")     = false
         *      StringUtils.isEmpty("  bob  ") = false
         * </pre>
         * <p>NOTE: This method changed in Lang version 2.0.
         * It no longer trims the CharSequence.
         * That functionality is available in isBlank().</p>
         * <pre>
         *      public static boolean isEmpty(final CharSequence cs) {
         *          return cs == null || cs.length() == 0;
         *      }
         * </pre>
         */
        boolean empty = StringUtils.isEmpty(s2); // false
        System.out.println(empty);



        /**
         * <p>Checks if a CharSequence is empty (""), null or whitespace only.</p>
         * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
         * <pre>
         *      StringUtils.isBlank(null)      = true
         *      StringUtils.isBlank("")        = true
         *      StringUtils.isBlank(" ")       = true
         *      StringUtils.isBlank("bob")     = false
         *      StringUtils.isBlank("  bob  ") = false
         * </pre>
         *
         * <pre>
         *      public static boolean isBlank(final CharSequence cs) {
         *          final int strLen = length(cs);
         *          if (strLen == 0) {
         *              return true;
         *          }
         *          for (int i = 0; i < strLen; i++) {
         *              if (!Character.isWhitespace(cs.charAt(i))) {
         *                  return false;
         *              }
         *          }
         *          return true;
         *     }
         * </pre>
         */
        boolean blank = StringUtils.isBlank(s2); // true
        System.out.println(blank);












    }
}
