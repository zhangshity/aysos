package com.zcy.desgin_pattern.factory.runoob.factory_pattern.shape.ShapeImpl;

import com.zcy.desgin_pattern.factory.runoob.factory_pattern.shape.Shape;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 14:46 2018/12/5
 * @ Modified: By:
 */

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
