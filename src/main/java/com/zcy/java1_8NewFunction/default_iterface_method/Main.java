package com.zcy.java1_8NewFunction.default_iterface_method;

public class Main {
    public static void main(String[] args) {

        //接口的static方法-接口名.静态方法名(使用方法和类的静态方法一样)
        Person.doStaticSomething();

        //接口default方法-需要其实现类点出
        Person person = new XiaoMing();
        person.doDefaultSomething();


    }


}
