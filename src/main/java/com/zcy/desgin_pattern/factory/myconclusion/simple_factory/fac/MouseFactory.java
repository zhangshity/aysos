package com.zcy.desgin_pattern.factory.myconclusion.simple_factory.fac;

import com.zcy.desgin_pattern.factory.myconclusion.simple_factory.classes.DellMouse;
import com.zcy.desgin_pattern.factory.myconclusion.simple_factory.classes.HpMouse;
import com.zcy.desgin_pattern.factory.myconclusion.simple_factory.classes.Mouse;

/**
 * @ Author: chunyang.zhang
 * @ Description:  简单工厂模式：
 * <p>             专门定义一个类负责创建其他类的实例。
 * <p>             被创建的类通常具有共同的父类。
 * @ Date: Created in 10:01 2018-12-17
 * @ Modified: By:
 */

public class MouseFactory {

    public Mouse makeMouse(String brand) {
        if (brand.equalsIgnoreCase("HP")) {
            return new HpMouse();
        } else if (brand.equalsIgnoreCase("DELL")) {
            return new DellMouse();
        }
        return null;
    }
}
