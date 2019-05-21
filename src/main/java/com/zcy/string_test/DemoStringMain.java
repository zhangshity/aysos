package com.zcy.string_test;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 13:39 2018-12-24
 * @ Modified: By:
 */

public class DemoStringMain {
    public static final String S_FIN = "123";

    //全局变量初值测试 3.无初值 line 154
    public static String staticStringNoValue;

    //全局变量初值测试 4.有初值 line 157
    public static String staticStringValueIsNull = null;

    public static void main(String[] args) {


        /**
         * @ Author: chunyang.zhang
         * @ Description: String基础测试
         * @ Date: Created in 10:32 2019-03-14
         * @ Modified: By:
         */
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

        /**
         * @ Author: chunyang.zhang
         * @ Description: String中 hascode() 方法测试
         * @ Date: Created in 10:31 2019-03-14
         * @ Modified: By:
         */
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


        /**
         * @ Author: chunyang.zhang
         * @ Description: 在String中  .equals()  和  == 的对比, 外加 .isEmpty() 方法校验
         * @ Date: Created in 10:30 2019-03-14
         * @ Modified: By:
         */
        System.out.println("\n\n" + "=========equals() 和 == 对比===============");
        String equalsTestString = "asd";

        System.out.println("String equalsTestString = \"asd\";");
        System.out.println("equalsTestString.equals(\"asd\") >> " + equalsTestString.equals("asd"));
        System.out.println("\n");

        //为什么相等,因为String建立放在常量池,所以不会创建新对象,而实际比较的是指向同一堆内存的引用,必然相等
        System.out.println("String equalsTestString = \"asd\";");
        System.out.println("(equalsTestString == \"asd\") >> " + (equalsTestString == "asd"));

        //【分析】1)  ==   比较引用,即栈内存（通常比较基本数据类型）
        //【分析】2)  .equals()   比较内容,即堆内存（String类型通常用此方法）

        //==============================================================================================
        System.out.println("\n\n" + "=========isEmpty() ==  对比===============");

        String noValue;
        String valueIsNull = null;

        System.out.println("\n");
        //编译错误见 line167-177 String不赋初值初始化
//        System.out.println(noValue == null);
//        System.out.println(noValue.isEmpty());
        System.out.println(valueIsNull == null);
//        System.out.println(valueIsNull.isEmpty());

        // isEmpty()只能 比较 "" 堆内存的空值,而不是 null 这种没有指向堆内存的 空引用
        // Exception in thread "main" java.lang.NullPointerException
        //	at com.zcy.string_test.DemoStringMain.main(DemoStringMain.java:132)


        /**
         * @ Author: chunyang.zhang
         * @ Description: String "" 的空显示问题
         * @ Date: Created in 10:52 2019-03-14
         * @ Modified: By:
         */
        System.out.println("\n\n" + "=========String \"\" 的空显示问题===============");

        String emptyString1 = null;
        String emptyString2 = "";

        System.out.println("String emptyString1 = null;  >>  " + emptyString1);
        System.out.println("String emptyString2 = \"\";  >>  " + emptyString2);

        /**
         * @Author: chunyang.zhang
         * @Description: String不赋初值初始化
         * @Date: Created in 16:31 2019-05-08
         * @Modified: By:
         */
        //String不赋初值初始化
        System.out.println("\n\n" + "=========String不赋初值初始化===============");

        String stringNoValue;
        String stringValueIsNull = null;

        //1.局部变量无初值: 此行无法通过编译,局部变量没有堆内存指向,空指针异常
//        System.out.println("String stringNoValue;  >>" + stringNoValue);

        //2.局部变量有初值null:
        System.out.println("String stringValueIsNull = null;  >>" + stringValueIsNull);

        //3.全局变量无初值:
        System.out.println("public static String staticStringNoValue;  >>" + staticStringNoValue);

        //4.全局变量有初值:
        System.out.println("public static String staticStringValueIsNull = null;  >>" + staticStringValueIsNull);


        /**
         * @Author:
         * @Description: String的substring()方法测试
         * @Date: Created in 15:32 2019-05-20
         * @Modified: By:
         */
        System.out.println("\n\n" + "=========String的substring()方法测试===============");

        String subStringMethod = "zxcvasdqwr";
        System.out.println("String subStringMethod = \"zxcvasdqwr\";  >>> " + subStringMethod);
        String trim1 = subStringMethod.substring(3);
        String trim2 = subStringMethod.substring(0, 3);
        int length = subStringMethod.length();
        System.out.println("String trim1 = subStringMethod.substring(3); >>> " + trim1);
        System.out.println("String trim2 = subStringMethod.substring(0, 3); >>> " + trim2);
        System.out.println("int length = subStringMethod.length(); >>> " + length);


        String sub1 = "12345er";
        String sub2 = "12345";
        System.out.println("拼接：>>> " + sub1.substring(sub2.length()));


        /**
         * @Description: startsWith()、endsWith()方法测试
         * @Date: Created in 11:13 2019-05-21
         * @Modified: By:
         */
        System.out.println("\n\n" + "=========String的substring()方法测试===============");
        String sd = "asd1234";
        String sd2 = "fff.txt";
        if (sd.startsWith("asd")) {
            System.out.println(sd2);
        }
        if (sd2.endsWith(".txt")) {
            System.out.println(sd2);
        }

    }


}


