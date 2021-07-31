package com.zcy.exception._1_standard_exception;

public class AssertErrorTest {
    public static void main(String[] args) {

        RuntimeException e = new RuntimeException("hahah ");
        System.out.println("----------- --------------");

        throw new AssertionError("??????", e);


    }
}
