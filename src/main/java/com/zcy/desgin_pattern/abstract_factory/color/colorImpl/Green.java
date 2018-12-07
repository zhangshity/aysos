package com.zcy.desgin_pattern.abstract_factory.color.colorImpl;

import com.zcy.desgin_pattern.abstract_factory.color.Color;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 14:23 2018/12/6
 * @ Modified: By:
 */

public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
