package com.zcy._extends.mthd_in_fathr_cls;

import com.zcy._extends.mthd_in_fathr_cls.test_class.Empty;

public abstract class Person {

    //验证自定义MyClassLoader中，未定义loadClass但是main中可调用，且结果与调用findClass相同
    public Class loadClass(String name) {
        System.out.println("father loadClass()");
        return findClass(name);
    }

    public Class findClass(String name) {
        System.out.println("father findClass()");
        return Empty.class;
    }
}
