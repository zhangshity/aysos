package com.zcy.test_interface;

import com.zcy.test_interface.JieKouCeShi;

public class JieKouCeShiImpl implements JieKouCeShi {

    public String dayin() {
        return "abstract方法！";
    }

    public String dayin2() {
        return "没有写public 和 abstract的方法";
    }

}
