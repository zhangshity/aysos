package com.zcy.desgin_pattern.factory.runoob.abstract_factory.factory;

import com.zcy.desgin_pattern.factory.runoob.abstract_factory.color.colorImpl.Blue;
import com.zcy.desgin_pattern.factory.runoob.abstract_factory.color.Color;
import com.zcy.desgin_pattern.factory.runoob.abstract_factory.color.colorImpl.Green;
import com.zcy.desgin_pattern.factory.runoob.abstract_factory.color.colorImpl.Red;
import com.zcy.desgin_pattern.factory.runoob.abstract_factory.shape.Shape;

/**
 * @ Author: chunyang.zhang
 * @ Description:  继承抽象工厂的 具体的 颜色工厂
 * @ Date: Created in 14:33 2018/12/6
 * @ Modified: By:
 */

public class ColorFactory extends AbstractFactory {


    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }

        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        }

        return null;
    }


    //父类抽象方法的继承,子类必须实现所有的抽象方法,否则就为抽象类(故,实现一个空Shape方法,不用)
    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
