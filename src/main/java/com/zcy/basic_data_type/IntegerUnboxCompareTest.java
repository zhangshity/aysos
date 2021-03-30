package com.zcy.basic_data_type;

import java.util.Objects;

public class IntegerUnboxCompareTest {
    public static void main2(String[] args) {
        int i1 = 128;
        Integer i2 = 128;
        Integer i3 = new Integer(128);
        System.out.println(i1 == i2);//true
        System.out.println(i1 == i3);//true
        System.out.println("**************************************");
        Integer i4 = 127;
        Integer i5 = 127;
        Integer i6 = 128;
        Integer i7 = 128;
        System.out.println(i4 == i5);//true
        System.out.println(i6 == i7);//false
        System.out.println("**************************************");
        Integer i8 = new Integer(127);
        Integer i9 = new Integer(127);
        System.out.println(i8 == i9);//false
        System.out.println(i8.equals(i9));//true
        System.out.println(i4 == i8);//false
    }


    //1. 第8和第9行的结果都为true。因为Integer与int比较时，Ingeger都会自动拆箱（jdk1.5以上）。
    //2. 第15行结果为true，第16行结果为false。
    // 因为Java在编译的时候，Integer i4=127被翻译成-> Integer i4= Integer.valueOf(127);


//    1.Ingeter是int的包装类，int的初值为0，Ingeter的初值为null。
//    2.无论如何，Integer与new Integer()不会相等。不会经历拆箱过程，i8的引用指向堆，而i4指向专门存放他的内存（常量池），他们的内存地址不一样，使用 == 比较都为false。
//    3.两个都是非new出来的Integer，使用 == 比较，如果数在-128到127之间，则是true，否则为false
//    4.两个都是new出来的，==比较都为false。若要比较值是否相等，需使用equals方法进行比较。
//    5int和Integer(无论new否)比，都为true，因为会把Integer自动拆箱为int再去比。


    /**
     * Interger的装箱和拆箱 (自动和手动)
     */
    int i1 = 500;
    Integer integer1 = new Integer(i1); // 手动装箱
    int i2 = integer1.intValue(); // 手动拆箱


    int i3 = 500;
    Integer integer2 = i3; // 自动装箱
    int i4 = integer2; // 自动拆箱







    //==================2020/12/12补充 Object.equals(var1,var2) 比较Integer===============
    public static void main(String[] args) {
        System.out.println("==================2020/12/12补充 Objects.equals(var1,var2) 比较Integer===============");
        int i1 = 127;
        Integer i2 = 127;
        System.out.println(Objects.equals(i1, i2));//true
        int i3 = 128;
        Integer i4 = 128;
        System.out.println(Objects.equals(i3, i4));//true
        System.out.println(i4.equals(i3)); //true

    }


}
