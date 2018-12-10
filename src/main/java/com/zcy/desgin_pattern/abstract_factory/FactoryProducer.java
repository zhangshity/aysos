package com.zcy.desgin_pattern.abstract_factory;

import com.zcy.desgin_pattern.abstract_factory.factory.AbstractFactory;
import com.zcy.desgin_pattern.abstract_factory.factory.ColorFactory;
import com.zcy.desgin_pattern.abstract_factory.factory.ShapeFactory;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 15:23 2018/12/6
 * @ Modified: By:
 */

public class FactoryProducer {

    public AbstractFactory getFactory(String choice) {

        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }

        return null;

    }
}
