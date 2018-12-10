package com.zcy.desgin_pattern.factory_pattern.shape.ShapeImpl;

import com.zcy.desgin_pattern.factory_pattern.shape.Shape;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 14:45 2018/12/5
 * @ Modified: By:
 */

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
