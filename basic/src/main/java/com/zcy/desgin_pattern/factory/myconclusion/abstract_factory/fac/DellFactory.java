package com.zcy.desgin_pattern.factory.myconclusion.abstract_factory.fac;

import com.zcy.desgin_pattern.factory.myconclusion.abstract_factory.classes.*;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 15:29 2018-12-17
 * @ Modified: By:
 */

public class DellFactory extends Factory {

    @Override
    public Mouse makeMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard makeKeyboard() {
        return new DellKeyboard();
    }
}
