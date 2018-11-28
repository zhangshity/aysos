package com.zcy.constructor;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 11:32 2018/11/28
 * @ Modified: By:
 * <p>
 * 问题描述:
 * ① 如果定义了一个有参数的构造函数，无参数的默认构造函数会失效，要想继续使用无参数的构造函数，必须使用重载重新定义一个无参数的构造函数？
 * ② 即使在类中自定义了一个无参数的构造函数，原先的那个系统默认的无参构造函数也会失效？
 * 综合成一句话：
 * 类中，只要有自定义的构造函数，无论是有参数的自定义构造函数还是无参数的自定义构造函数，默认的那个无参构造函数就一定失效了？
 * <p>
 * <p>
 * <p>
 * <p>
 * -  总结:
 * -
 * -    如果一个类，你没有定义构造函数，那么系统默认会有一个无参的构造函数。
 * -    但如果你定义了一个有参的构造函数，为了保证正确性，系统不会创建无参构造函数，这时候，如果你还想允许无参构造，就必须显式的声明一个
 */


public class ConstructorTest {

    public static class Car {
        int length;
        String color;

//        //构造函数重载overload
//        Car(int length,String color) {
//            this.length = length;
//            this.color = color;
//        }

        //构造函数重载overload
        Car(int l, String c) {
            length = l;  //可以不加this.
            color = c;   //可以不加this.
        }


        // 重写toString方法
        @Override
        public String toString() {
            return "Car{" +
                    "length=" + length +
                    ", color='" + color + '\'' +
                    '}';
        }
    }


//=================主函数 main============================================================
//    public static void main(String args[]) {
//
////        Car car = new Car();//自定义了构造函数，不会创建默认空构造函数，如想使用只能显示定义
//
////        //类中的变量(成员方法)可以通过:1 .变量名来访问。2 getter、setter方法来访问。3 构造函数赋值
////        car.color = "red";
////        car.length = 15;
//
//
//        Car car = new Car(15, "red");
//
//        System.out.println("Car Informations:" + car.toString());
//
//    }
//}
