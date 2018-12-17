package com.zcy.desgin_pattern.factory.myconclusion.abstract_factory.fac;

import com.zcy.desgin_pattern.factory.myconclusion.abstract_factory.classes.HpKeyboard;
import com.zcy.desgin_pattern.factory.myconclusion.abstract_factory.classes.HpMouse;
import com.zcy.desgin_pattern.factory.myconclusion.abstract_factory.classes.Keyboard;
import com.zcy.desgin_pattern.factory.myconclusion.abstract_factory.classes.Mouse;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 15:35 2018-12-17
 * @ Modified: By:
 */

public class HpFactory extends Factory {

    @Override
    public Mouse makeMouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard makeKeyboard() {
        return new HpKeyboard();
    }
}
