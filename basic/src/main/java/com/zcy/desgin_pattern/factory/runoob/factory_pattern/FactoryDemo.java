package com.zcy.desgin_pattern.factory.runoob.factory_pattern;

import com.zcy.desgin_pattern.factory.runoob.factory_pattern.shape.Shape;

/**
 * @ Author: chunyang.zhang
 * @ Description: 工厂类主函数调用
 * @ Date: Created in 15:06 2018/12/5
 * @ Modified: By:
 */

public class FactoryDemo {

    public static void main(String args[]) {

        //1实例化工厂类
        ShapeFactory shapeFactory = new ShapeFactory();

        //2给工厂筛选条件，创建对象并返回

        Shape cricle = shapeFactory.getShape("circle");
        cricle.draw();

        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.draw();

        Shape square = shapeFactory.getShape("square");
        square.draw();
    }
}
