package com.zcy.exception;

public class GetMessageTest {
    public static void main(String[] args) {

        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            System.out.println(e.getCause());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getStackTrace());
            System.out.println(e.getSuppressed());
        }





    }
}
