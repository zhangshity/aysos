package com.zcy.desgin_pattern.factory.runoob.abstract_factory.shape.shapeImpl;

import com.zcy.desgin_pattern.factory.runoob.abstract_factory.shape.Shape;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 14:20 2018/12/6
 * @ Modified: By:
 */

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
