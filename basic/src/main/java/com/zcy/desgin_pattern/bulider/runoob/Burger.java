package com.zcy.desgin_pattern.bulider.runoob;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 16:45 2018-12-17
 * @ Modified: By:
 */

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
