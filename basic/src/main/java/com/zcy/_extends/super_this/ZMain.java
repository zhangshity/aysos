package com.zcy._extends.super_this;

public class ZMain {

    public static void main(String[] args) {

        Son son = new Son();

        /**
         *  method1子类重写了父类的方法
         *  method2只有父类有，子类没有
         *
         *  this.method1();   //son m1
         *  super.method1();  //father m1
         *  this.method2();   //father m2
         *  super.method2();  //father m2
         */
        son.super2thisTest();
    }
}
