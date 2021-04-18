package com.zcy.desgin_pattern.factory.runoob.abstract_factory.color.colorImpl;

import com.zcy.desgin_pattern.factory.runoob.abstract_factory.color.Color;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 14:24 2018/12/6
 * @ Modified: By:
 */

public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
