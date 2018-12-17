package com.zcy.desgin_pattern.factory.runoob.factory_pattern;

import com.zcy.desgin_pattern.factory.runoob.factory_pattern.shape.ShapeImpl.Circle;
import com.zcy.desgin_pattern.factory.runoob.factory_pattern.shape.ShapeImpl.Rectangle;
import com.zcy.desgin_pattern.factory.runoob.factory_pattern.shape.Shape;
import com.zcy.desgin_pattern.factory.runoob.factory_pattern.shape.ShapeImpl.Square;

/**
 * @ Author: chunyang.zhang
 * @ Description: Shape的工厂类
 * @ Date: Created in 14:51 2018/12/5
 * @ Modified: By:
 */

public class ShapeFactory {

    //定义拿取方法
    public Shape getShape(String ShapeType) {

        if (ShapeType == null) { //类型空值返回空
            return null;
        }


        if (ShapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (ShapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (ShapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }

        return null;


    }
}
