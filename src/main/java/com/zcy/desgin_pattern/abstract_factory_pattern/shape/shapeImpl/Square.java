package com.zcy.desgin_pattern.abstract_factory_pattern.shape.shapeImpl;

import com.zcy.desgin_pattern.abstract_factory_pattern.shape.Shape;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 14:17 2018/12/6
 * @ Modified: By:
 */

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
