package com.zcy.desgin_pattern.factory_pattern;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 14:41 2018/12/5
 * @ Modified: By:
 */

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
