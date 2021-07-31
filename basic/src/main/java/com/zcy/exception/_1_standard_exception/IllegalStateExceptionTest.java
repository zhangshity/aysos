package com.zcy.exception._1_standard_exception;

public class IllegalStateExceptionTest {
    public static void main(String[] args) {

        Exception e = new NullPointerException();

        int type = 3;
        switch (type) {
            case 0:
                throw new IllegalStateException();
            case 1:
                throw new IllegalStateException("非法状态异常:");
            case 2:
                throw new IllegalStateException(e);
            case 3:
                throw new IllegalStateException("非法状态异常:", e);

        }

    }
}
