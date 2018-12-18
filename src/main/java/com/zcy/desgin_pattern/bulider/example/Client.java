package com.zcy.desgin_pattern.bulider.example;

public class Client {

    public static void main(String[] args) {

        ConcreteBuilder1 b1 = new ConcreteBuilder1();//建造者
        Director director = new Director(b1);//监工
        director.construct();//建造实例(监工负责监督，建造者实际建造)
        String result = b1.getResult();//获取最终生成结果
        System.out.printf("the result is :%n%s", result);

    }

//    public void testBuilderPattern() {
//        ConcreteBuilder1 b1 = new ConcreteBuilder1();//建造者
//        Director director = new Director(b1);//监工
//        director.construct();//建造实例(监工负责监督，建造者实际建造)
//        String result = b1.getResult();//获取最终生成结果
//        System.out.printf("the result is :%n%s", result);
//    }
}
