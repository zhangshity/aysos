package com.zcy.variable;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《形参测试》
 * @ Date: Created in 21:12 2020/7/18
 * @ Modified: By:
 */
public class FormalParameterTest {
    public static void main(String[] args) {
        int a = 6;
        //int a = 600;
        int b = 9;
        //int b = 900;
        System.out.println("基本变量a地址 " + System.identityHashCode(a)); //基本变量a地址 218365679    //基本变量a地址 1096325556
        System.out.println("基本变量c地址 " + System.identityHashCode(b)); // 基本变量c地址 -643712286  //基本变量c地址 1019384619

        System.out.println("============调用测试方法================");
        swap(a, b);
    }

    //形参测试方法
    public static void swap(int c, int d) {
        System.out.println(c); //6  //600
        System.out.println(d); //9  //900
        System.out.println("形参c地址 " + System.identityHashCode(c)); //形参c地址 218365679   //形参c地址 322279800
        System.out.println("形参d地址 " + System.identityHashCode(d)); //形参d地址 -643712286  //形参d地址 -1264907899
    }

    /**
     * 【Q&A】-问题：
     * Q:
     * System.identityHashCode()；是根据内存地址计算得出的哈希码，内存地址不一样，得出的哈希码也不一样，可以看出a的地址和c的地址竟然是一样的？
     * 可是书上明明说的是，形参属于局部变量，当程序运行到该方法时，会为形参分配栈内存。既然重新分配了内存，那么为什么a和c的地址还会是一样的？
     *
     * A:
     * 首先，hashCode()方法是Object类的方法，System.identityHashCode(Object X)返回值与其相同，传入int值会被自动装箱成Integer类型。
     *      (即基本变量无法使用hashCode()方法拿到内存地址,只有引用才可以通过hashCode()拿到其对象的内存地址)
     * 其次，包装类加载时，其值会被纳入常量池中缓存，包括String常量和Integer (-128-127)。 c确实是形参，但是
     *      a,c的System.identityHashCode()却是对象Integer.valueOf(6),输出的地址自然就是一样的。你可以把6换成600，就不会在创建在常量池了，而是在堆中，这样地址就不可能一样了。
     */

}
