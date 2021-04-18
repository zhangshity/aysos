package com.zcy.desgin_pattern.factory.myconclusion.simple_factory;

import com.zcy.desgin_pattern.factory.myconclusion.simple_factory.classes.Mouse;
import com.zcy.desgin_pattern.factory.myconclusion.simple_factory.fac.MouseFactory;

public class DemoMain {

    public static void main(String[] args) {
        MouseFactory mouseFactory = new MouseFactory();

        Mouse dell = mouseFactory.makeMouse("dell");
        dell.sayHi();

        Mouse hp = mouseFactory.makeMouse("hp");
        hp.sayHi();


    }
}
