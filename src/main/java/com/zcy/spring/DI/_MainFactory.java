package com.zcy.spring.DI;

public class _MainFactory {

    public static void main(String[] args) { //--- 此主类即为IOC容器(IOC Cotainer)

        //依赖注入(底层类作为参数传递给上层类)
        Tire tire = new Tire();
        Bottom bottom = new Bottom(tire);
        Frame frame = new Frame(bottom);
        Car car = new Car(frame);

        car.move();
    }
}
