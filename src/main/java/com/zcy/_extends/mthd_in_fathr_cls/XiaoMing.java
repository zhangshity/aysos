package com.zcy._extends.mthd_in_fathr_cls;

import com.zcy._extends.mthd_in_fathr_cls.test_class.Vacant;

public class XiaoMing extends Person {

    @Override
    public Class findClass(String name) {
        System.out.println("son findClass()");
        return Vacant.class;
    }
}
