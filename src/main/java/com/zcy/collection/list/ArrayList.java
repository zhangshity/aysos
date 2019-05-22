package com.zcy.collection.list;

import java.util.List;

/**
 * @ Author: chunyang.zhang
 * @ Description: ArrayList测试
 * @ Date: Created in 13:59 2019-03-13
 * @ Modified: By:
 */

public class ArrayList {

    public static void main(String[] args) {

        /**
         * @ Author: chunyang.zhang
         * @ Description: List .size()函数和 get(index)的用法
         * @ Date: Created in 14:03 2019-03-13
         * @ Modified: By:
         */
        System.out.println("=====size()函数和 get(index)的用法===========");
        List<String> stringList = new java.util.ArrayList<>();
        stringList.add("1asd");
        stringList.add("2asd");
        stringList.add("3asd");
        stringList.add("4asd");

        System.out.println("stringList.size() >>> " + stringList.size());

        String getsomething = stringList.get(stringList.size() - 1);

        System.out.println("stringList.size() - 1 >>> " + getsomething);


        /**
         * @ Author: chunyang.zhang
         * @ Description: 字符串的 equals() 和 == 对比
         * @ Date: Created in 13:48 2019-03-13
         * @ Modified: By:
         */
        System.out.println("\n" + "=======字符串的 equals() 和 == 对比 ========");
        String a_String = null;

        List<String> stringList2 = new java.util.ArrayList<>(); //list为空
//        stringList2.add(a_String);

        // list为空 比较方法 1
        System.out.println("stringList2.size() == 0比较方法结果：>>> "
                + (stringList2.size() == 0));
        // list为空 比较方法 2
        System.out.println("stringList2.isEmpty()比较方法结果：>>> "
                + stringList2.isEmpty());

    }
}
