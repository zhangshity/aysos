package com.zcy.desgin_pattern.factory.runoob.abstract_factory.factory;

import com.zcy.desgin_pattern.factory.runoob.abstract_factory.color.Color;
import com.zcy.desgin_pattern.factory.runoob.abstract_factory.shape.shapeImpl.Circle;
import com.zcy.desgin_pattern.factory.runoob.abstract_factory.shape.shapeImpl.Rectangle;
import com.zcy.desgin_pattern.factory.runoob.abstract_factory.shape.Shape;
import com.zcy.desgin_pattern.factory.runoob.abstract_factory.shape.shapeImpl.Square;

/**
 * @ Author: chunyang.zhang
 * @ Description: 继承抽象工厂的 具体的 形状工厂
 * @ Date: Created in 14:44 2018/12/6
 * @ Modified: By:
 */

public class ShapeFactory extends AbstractFactory {

    //父类抽象方法的继承,子类必须实现所有的抽象方法,否则就为抽象类(故,实现一个空Color方法,不用)
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if (shape == null) {
            return null;
        }

        if (shape.equalsIgnoreCase("SQUARE")) {
            return new Square();
        } else if (shape.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shape.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        }

        return null;
    }
}
