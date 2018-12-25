package com.zcy.string_test;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 13:39 2018-12-24
 * @ Modified: By:
 */

public class DemoStringMain {
    public static final String S_FIN = "123";

    public static void main(String[] args) {
        String s1 = "123";

        String s2 = "222";

        String s3 = "123";


        StringBuffer stringBuffer = new StringBuffer("123");
        System.out.println("stringBuffer:" + stringBuffer);//123
        StringBuffer sb1 = stringBuffer.append("ahahah");
        System.out.println("stringBufer after appen:" + stringBuffer);//123ahahah
        System.out.println("sb1 = stringBuffer.append()" + sb1);//123ahahah

        System.out.println(sb1);
        System.out.println("sb1 == stringBuffer :" + (stringBuffer == sb1));

        String s4 = new String("123");

        System.out.println(S_FIN == s1);

        System.out.println(s1.hashCode());

        System.out.println(s2.hashCode());

        System.out.println(s3.hashCode());

        System.out.println(s4.hashCode());

        System.out.println(S_FIN.hashCode());

        //===========================================================
        System.out.println("==========================================");
        //String
        String str1 = new String("123");
        String str2 = "123";
        String str3 = "123" + "abc";

        System.out.println("new String(123)  " + str1);
        System.out.println("=" + "123  " + str2);
        System.out.println("str1.hashCode()  " + str1.hashCode());
        System.out.println("str2.hashCode()  " + str2.hashCode());
        System.out.println("str1 ?= str2  " + (str1 == str2));
        //=======================================================================
        //比较测试
        System.out.println("======================================");
        StringBuilder stringBuilder = new StringBuilder("stringbuilder");
        StringBuffer stringBuffer1 = new StringBuffer("StringBuffer");
        String string = "String";

        stringBuffer1.reverse();
        stringBuilder.append(123321);
        System.out.println("StingBuilder: " + stringBuilder + "\n" +
                "StringBuffer: " + stringBuffer1 + "\n" +
                "String: " + string + "\n");

        System.out.println("StringBuffer 和 StringBuilder 绝对方法大多相同。" +
                "且均继承AbstractStringBuilder。" +
                "但在继承的实现上。StringBuffer大多加入了Syschronized修饰符,保证线程安全。但牺牲了部分性能");

        //StringBuffer 和 StringBuilder 绝对方法大多相同。
        //且均继承AbstractStringBuilder。
        //但在继承的实现上。StringBuffer大多加入了Syschronized修饰符,保证线程安全。但牺牲了部分性能
    }
}


