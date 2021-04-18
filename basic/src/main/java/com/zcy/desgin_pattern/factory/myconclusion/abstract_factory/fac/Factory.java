package com.zcy.desgin_pattern.factory.myconclusion.abstract_factory.fac;

import com.zcy.desgin_pattern.factory.myconclusion.abstract_factory.classes.Keyboard;
import com.zcy.desgin_pattern.factory.myconclusion.abstract_factory.classes.Mouse;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 15:24 2018-12-17
 * @ Modified: By:
 */

public abstract class Factory {

    public abstract Mouse makeMouse();

    public abstract Keyboard makeKeyboard();

}
