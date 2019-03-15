package com.zcy.interface_test.override_annotation.interface_class;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 15:58 2019-01-17
 * @ Modified: By:
 * <p>
 * 为了测试 @Override 注解
 */
public class CarImpl implements Car {


    @Override
    public String doSomething(Integer id) {
        if (id == null) {
            return "id do not match ~";
        }
        return "good id , no brand ~";
    }

    //@Override
    // 父类接口中没有此抽象方法,但子类依然可以新的方法,且可以调用。
    // 如果加了 @Override注解,就不可以,因为这个伪注解会判断
    public String doShit() {
        return "This method do not exist in Car interface！";
    }
}
