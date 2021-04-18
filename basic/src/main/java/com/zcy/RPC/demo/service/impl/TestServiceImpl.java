package com.zcy.RPC.demo.service.impl;

import com.zcy.RPC.demo.service.TestService;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 16:13 2019-08-14
 * @ Modified: By:
 */
public class TestServiceImpl implements TestService {

    public String test(String name) {
        System.out.println(name);
        return "return" + name;
    }


}
