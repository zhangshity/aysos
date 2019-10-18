package com.zcy.spring.original;

public class Car {

    private Frame frame;

    public Car() {
        this.frame = new Frame();
    }


    public void move() {
        System.out.println("顶层依赖move()方法，创建成功");
    }
}
