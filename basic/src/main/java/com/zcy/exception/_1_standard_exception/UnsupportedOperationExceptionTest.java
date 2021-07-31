package com.zcy.exception._1_standard_exception;

public class UnsupportedOperationExceptionTest {

    public static void main(String[] args) {

        Exception e = new NullPointerException();

        int type = 3;
        switch (type) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                throw new UnsupportedOperationException("非法状态异常:");
            case 2:
                throw new UnsupportedOperationException(e);
            case 3:
                throw new UnsupportedOperationException("非法状态异常:", e);

        }

    }
}
