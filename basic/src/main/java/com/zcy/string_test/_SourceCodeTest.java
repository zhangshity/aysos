package com.zcy.string_test;

public class _SourceCodeTest {
    public static void main(String[] args) {

        /**
         * 1. 空参数构造器(默认值为"")
         *  public String() {
         *      this.value = "".value;
         *  }
         */
        String s = new String(); //跟String s = "";一样的效果
        System.out.println("{s=" + s + "}");
        System.out.println("".isEmpty());

        //Object的HashCode() 和 Object中的toString()
        _SourceCodeTest sourceCodeTest = new _SourceCodeTest();
        _SourceCodeTest sourceCodeTest1 = new _SourceCodeTest();
        System.out.println(sourceCodeTest.hashCode() + " " + sourceCodeTest1.hashCode());
        System.out.println(sourceCodeTest.toString() + " " + sourceCodeTest1.toString());
        //String重写了hashCode方法,返回的不是真正的hashcode


        /**
         *  2.intern()方法
         *
         *  解释1. 在JDK 1.7下，当执行str2.intern();时，因为常量池中没有“str01”这个字符串，
         *  所以会在常量池中生成一个对堆中的“str01”的引用
         *  (注意这里是引用 ，就是这个区别于JDK 1.6的地方。在JDK1.6下是生成原字符串的拷贝)，
         *  而在进行String str1 = “str01”;字面量赋值的时候，常量池中已经存在一个引用，
         *  所以直接返回了该引用，因此str1和str2都指向堆中的同一个字符串，返回true。
         */
        String so = new String("abcd");
        String sw = "abcd";
        String sointern = so.intern();
        System.out.println(sointern == sw);

        String str22 = new String("str") + new String("01");
        str22.intern();
        String str11 = "str01";
        System.out.println(str22 == str11);

        String str2 = new String("str") + new String("01");
        String str1 = "str01";
        str2.intern();
        System.out.println(str2 == str1);

        //解释2. 将中间两行调换位置以后，因为在进行字面量赋值（String str1 = “str01″）的时候，
        //常量池中不存在，所以str1指向的常量池中的位置，
        //而str2指向的是堆中的对象，再进行intern方法时，因为常量池已经有str1,所以不会在生成新的变量，
        //其返回值与str1相同，但是intern()对str1和str2已经没有影响了，所以返回false。


        /**
         * 3.String StringBuilder StringBuffer 原理理解
         * 以及 + 和 += 的使用
         * String
         */
        // ========= String + ============================
        long startTime1 = System.currentTimeMillis(); // 开始时间
        String st = "";
        for (int i = 0; i < 10000; i++) {
            st += "a";
        }
        long endTime1 = System.currentTimeMillis(); // 开始时间
        System.out.println("String +=，执行时间：" + (endTime1 - startTime1));

        // ========= StringBuilder append() ==============
        long startTime2 = System.currentTimeMillis(); // 开始时间
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append("a");
        }
        long endTime2 = System.currentTimeMillis(); // 开始时间
        System.out.println("StringBuilder 拼加，执行时间：" + (endTime2 - startTime2));

        //去看StringBuilder源码
        StringBuilder strbud = new StringBuilder();
        StringBuffer strbuf = new StringBuffer();
        //String存值的变量是 private final char value[];
        //StringBuilder是  char value[];  (继承自AbstractStringBuilder成员变量)


    }


}
