package com.zcy.spring.DI;

public class Car {

    private Frame frame;

    public Car(Frame frame) {
        this.frame = frame;
    }


    public void move() {
        System.out.println("DI底层类 传递给上层成功");
    }
}
