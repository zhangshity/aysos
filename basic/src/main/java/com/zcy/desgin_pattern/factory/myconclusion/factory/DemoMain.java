package com.zcy.desgin_pattern.factory.myconclusion.factory;

import com.zcy.desgin_pattern.factory.myconclusion.factory.classes.Mouse;
import com.zcy.desgin_pattern.factory.myconclusion.factory.fac.DellMouseFactory;
import com.zcy.desgin_pattern.factory.myconclusion.factory.fac.HpMouseFactory;
import com.zcy.desgin_pattern.factory.myconclusion.factory.fac.MouseFactory;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 13:41 2018-12-17
 * @ Modified: By:
 */

public class DemoMain {

    public static void main(String[] args) {

        //戴尔工厂 生产 戴尔鼠标
        MouseFactory dellMouseFactory = new DellMouseFactory();
        Mouse dellMouse = dellMouseFactory.makeMouse();
        dellMouse.sayHi();

        //惠普工厂 生产 惠普鼠标
        MouseFactory hpMouseFactory = new HpMouseFactory();
        Mouse hpMouse = hpMouseFactory.makeMouse();
        hpMouse.sayHi();

    }
}
