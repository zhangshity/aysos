package com.zcy.string_test;

/**
 * intern() 总是返回的是池中的对象(的引用)
 *
 * 池中有就直接返回，没有就加进去在返回。  (jdk1.8池中存的是对象)
 *
 *         String str1 = new String("abc");
 *         String str2 = str1.intern();
 *         如果池中存的是引用，str1 == str2 为ture，可是，其实为false。证明，池中存储了一个新对象
 */
public class __1_InternTest {
    public static void main(String[] args) {
        String s1 = "Javatpoint";
        String s2 = s1.intern();
        String s3 = new String("Javatpoint");
        String s4 = s3.intern();
        System.out.println(s1==s2); // True
        System.out.println(s1==s3); // False
        System.out.println(s1==s4); // True
        System.out.println(s2==s3); // False
        System.out.println(s2==s4); // True
        System.out.println(s3==s4); // False


        // ================
        System.out.println(" ================");
        String str1 = new String("abc");
        String str2 = str1.intern();
        System.out.println(str1 == str2); //false
      
    }
}
