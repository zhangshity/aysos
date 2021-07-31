package com.zcy.exception._1_standard_exception;

public class IllegalArgumentExceptionTest {
    public static void main(String[] args) {

        Exception e = new NullPointerException();

        int type = 3;
        switch (type) {
            case 0:
                throw new IllegalArgumentException();
            case 1:
                throw new IllegalArgumentException("非法参数异常:");
            case 2:
                throw new IllegalArgumentException(e);
            case 3:
                throw new IllegalArgumentException("非法参数异常:", e);

        }
    }
}
