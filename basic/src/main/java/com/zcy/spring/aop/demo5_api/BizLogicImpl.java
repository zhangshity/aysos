package com.zcy.spring.aop.demo5_api;

public class BizLogicImpl implements BizLogic {

    @Override
    public String save() {
        System.out.println("BizLogicImpl: Logic save.");

        return "Logic save.";
    }
}
