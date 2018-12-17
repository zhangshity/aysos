package com.zcy.desgin_pattern.factory.myconclusion.factory.fac;

import com.zcy.desgin_pattern.factory.myconclusion.factory.classes.HpMouse;
import com.zcy.desgin_pattern.factory.myconclusion.factory.classes.Mouse;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 13:38 2018-12-17
 * @ Modified: By:
 */

public class HpMouseFactory implements MouseFactory {

    @Override
    public Mouse makeMouse() {
        return new HpMouse();
    }
}
