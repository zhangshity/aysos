package com.zcy.string_test;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 13:39 2018-12-24
 * @ Modified: By:
 */

public class DemoStringMain {
    public static final String S_FIN = "123";

    //全局变量初值测试 3.无初值 line 169
    public static String staticStringNoValue;

    //全局变量初值测试 4.有初值 line 172
    public static String staticStringValueIsNull = null;

    public static void main(String[] args) {


        /**
         * @ Author: chunyang.zhang
         * @ Description: 1.String基础测试
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
         * @ Description: 2.String中 hascode() 方法测试
         * @ Date: Created in 10:31 2019-03-14
         * @ Modified: By:
         */
        //===========================================================
        System.out.println("===========2.String中 hascode() 方法测试===============================");
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
         * @ Description: 3.在String中  .equals()  和  == 的对比, 外加 .isEmpty() 方法校验
         * @ Date: Created in 10:30 2019-03-14
         * @ Modified: By:
         */
        System.out.println("\n\n" + "=========3.equals() 和 == 对比===============");
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
        System.out.println("\n\n" + "=========3.isEmpty() ==  对比===============");

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
         * @ Description: 4.String "" 的空显示问题
         * @ Date: Created in 10:52 2019-03-14
         * @ Modified: By:
         */
        System.out.println("\n\n" + "=========4.String \"\" 的空显示问题===============");

        String emptyString1 = null;
        String emptyString2 = "";

        System.out.println("String emptyString1 = null;  >>  " + emptyString1);
        System.out.println("String emptyString2 = \"\";  >>  " + emptyString2);

        /**
         * @Author: chunyang.zhang
         * @Description: 5.String不赋初值初始化
         * @Date: Created in 16:31 2019-05-08
         * @Modified: By:
         */
        //String不赋初值初始化
        System.out.println("\n\n" + "=========5.String不赋初值初始化===============");

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
         * @Description: 6.String的substring()方法测试
         * @Date: Created in 15:32 2019-05-20
         * @Modified: By:
         */
        System.out.println("\n\n" + "=========6.String的substring()方法测试===============");

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
         * @Description: 7.startsWith()、endsWith()方法测试
         * @Date: Created in 11:13 2019-05-21
         * @Modified: By:
         */
        System.out.println("\n\n" + "=========7.String的substring()方法测试===============");
        String sd = "asd1234";
        String sd2 = "fff.txt";
        if (sd.startsWith("asd")) {
            System.out.println(sd2);
        }
        if (sd2.endsWith(".txt")) {
            System.out.println(sd2);
        }


        /**
         * 8.测试字符串 直接赋值 和 new新对象的区别
         * String s1 = "abc";
         * String s2 = new String("abc");
         */
        System.out.println("\n\n" + "=========8.直接赋值 和 new新对象的区别===============");
        String directValue = "abc";
        String newObject = new String("abc");

        System.out.println("String directValue = \"abc\"; >>> " + directValue);
        System.out.println("String newObject = new String(\"abc\"); >>> " + newObject);
        System.out.println("(directValue==newObject) >>> " + (directValue == newObject));

        String newObject2 = new String("abc");
        String directValue2 = "abc";

        System.out.println("\n" + "String newObject2 = new String(\"abc\"); >>> " + newObject2);
        System.out.println("String directValue2 = \"abc\"; >>> " + directValue2);
        System.out.println("(directValue == directValue2) >>> " + (directValue == directValue2));
        System.out.println("(newObject == newObject2) >>> " + (newObject == newObject2));

        //总结:
        //1.直接赋值在常量池创建对象,new String()也是在常量池
        //2.区别:
        //   直接赋值: 会在常量池中寻找有无已经创建的String对象，有就直接引用指向此地址，没有在创建新的然后指向此地址
        //   new新对象:强制在常量池创建新的String对象，不管是否重复，都是新创建(可以看到IDE弹出警告重复变量,通过编译但是重复)
        //3.结论: 最好直接赋值节省资源。除非特殊情况一定要要不同对象


        //特殊例子(例题):
        System.out.println("\n" + "=========8.直接赋值 和 new新对象的区别(例题)===============");
        //String str1 = "ABC";
        //String str2 = new String("ABC");
        /**
         * String str1 = “ABC”;可能创建一个或者不创建对象，如果”ABC”这个字符串在java String池里不存在，会在java String池里创建一个创建一个String对象 (“ABC”)，然后str1指向这个内存地址，
         * 无论以后用这种方式创建多少个值为”ABC”的字符串对象，始终只有一个内存地址被分配，之后的都是String的拷贝，Java中称为“字符串驻留”，所有的字符串常量都会在编译之后自动地驻留。
         *
         * String str2 = new String(“ABC”); 至少创建一个对象，也可能两个。因为用到new关键字，肯定会在heap中创建一个str2的String对象，它的value是“ABC”。
         * 同时如果这个字符串再java String池里不存在，会在java池里创建这个String对象“ABC”。
         *
         * 在JVM里，考虑到垃圾回收（Garbage Collection）的方便，将heap(堆) 划分为三部分：young generation (新生代)、tenured generation （old generation）（旧生代）、permanent generation（永生代）。
         *
         * 字符串为了解决字符串重复问题，生命周期长，存于pergmen中。
         *
         * JVM中，相应的类被加载运行后，常量池对应的映射到JVM运行时的常量池中。
         *
         * 考虑下面的问题：
         */


        String str11 = new String("ABC");
        String str22 = new String("ABC");

        //str1 == str2的值是true还是false呢？false

        String str33 = "ABC";
        String str44 = "ABC";
        String str55 = "AB" + "C";
        System.out.println(str33 == str44); //true
        System.out.println(str33 == str55); // true


        String a = "ABC";
        String b = "AB";
        String c = b + "C";
        System.out.println(a == c); //false

        /**
         * a、b在编译时就已经被确定了，而c是引用变量，不会在编译时就被确定。
         *
         * 应用的情况：建议在平时的使用中，尽量使用String = “abcd”;这种方式来创建字符串，而不是String = new String(“abcd”);
         * 这种形式，因为使用new构造器创建字符串对象一定会开辟一个新的heap空间，而双引号则是采用了String interning(字符串驻留)进行了优化，效率比构造器高。
         *
         */
        //=====================================================================================================


        /**
         * @ Author: chunyang.zhang
         * @ Description: 9
         * @ Date: Created in 14:43 2019-05-22
         * @ Modified: By:
         */

    }


}


