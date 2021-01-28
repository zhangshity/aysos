package com.zcy.exception;

import java.util.ArrayList;
import java.util.List;

public class FinallyReturnTest {
    public static void main(String[] args) {

        FinallyReturnTest method = new FinallyReturnTest();
        List<String> list = method.test();
        System.out.println(list);
    }


    public List<String> test() {
        List<String> list = new ArrayList<>();
        try {
            list.add("1");
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            list.add("2");
        }
        return null;
    }
}
