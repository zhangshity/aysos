package com.zcy.string_test;

/**
 * @ Author: chunyang.zhang
 * @ Description: 理解String方法 isEmpty()
 * @ Date: Created in 19:31 2020/5/27
 * @ Modified: By:
 * <p>SourceCode 源码:
 * <p>
 * <code>   public boolean isEmpty() {
 * <code>       return value.length == 0;
 * <code>   }
 */
public class IsEmptyEquals {
    public static void main(String[] args) {

        String s = "";
        String s1 = null;
        String s2 = new String();

        System.out.println(s.isEmpty());
//        System.out.println(s1.isEmpty()); // NullPointerException
        System.out.println(s2.isEmpty());

// String 无参构造函数:
//       public String() {
//           this.value = "".value;
//       }
//      String空参构造函数赋值为""

        /**
         *结论:
         *     s != null    :如果传进空值 ""  ,则不能正确判断结果
         *     s.isEmpty()  :如果s未赋初值为null ,则空指针异常
         *     s.equals()   :如果传入null和""  ,均可,方法内会做判断
         */

        System.out.println(s.equals(""));
//        System.out.println(s1.equals(""));
        System.out.println(s2.equals(""));
        System.out.println(s.equals(s2));

    }
}
