package com.zcy.desgin_pattern.factory.runoob.abstract_factory.factory;

import com.zcy.desgin_pattern.factory.runoob.abstract_factory.color.Color;
import com.zcy.desgin_pattern.factory.runoob.abstract_factory.shape.Shape;

/**
 * @ Author: chunyang.zhang
 * @ Description: 抽象工厂
 * @ Date: Created in 14:26 2018/12/6
 * @ Modified: By:
 */

public abstract class AbstractFactory {

    public void shit() { //就任性定一个空狗屎方法
    }

    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);

}
