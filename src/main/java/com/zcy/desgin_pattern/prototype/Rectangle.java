package com.zcy.desgin_pattern.prototype;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 13:56 2018/12/11
 * @ Modified: By:
 */

public class Rectangle extends Shape {

    //protected属性type继承父类(默认不声明)

    //利用constructor给继承来的属性type赋值
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
