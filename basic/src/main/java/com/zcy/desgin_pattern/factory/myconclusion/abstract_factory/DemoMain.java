package com.zcy.desgin_pattern.factory.myconclusion.abstract_factory;

import com.zcy.desgin_pattern.factory.myconclusion.abstract_factory.classes.Keyboard;
import com.zcy.desgin_pattern.factory.myconclusion.abstract_factory.classes.Mouse;
import com.zcy.desgin_pattern.factory.myconclusion.abstract_factory.fac.DellFactory;
import com.zcy.desgin_pattern.factory.myconclusion.abstract_factory.fac.Factory;
import com.zcy.desgin_pattern.factory.myconclusion.abstract_factory.fac.HpFactory;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 15:36 2018-12-17
 * @ Modified: By:
 */

public class DemoMain {

    public static void main(String[] args) {

        //惠普
        Factory hpFactory = new HpFactory();
        Keyboard keyboard1 = hpFactory.makeKeyboard();
        Mouse mouse1 = hpFactory.makeMouse();
        keyboard1.sayHi();
        mouse1.sayHi();

        //戴尔
        Factory dellFactory = new DellFactory();
        Keyboard keyboard2 = dellFactory.makeKeyboard();
        Mouse mouse2 = dellFactory.makeMouse();
        keyboard2.sayHi();
        mouse2.sayHi();

    }
}
