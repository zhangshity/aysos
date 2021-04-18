package com.zcy.regular_expression;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 17:36 2019-01-17
 * @ Modified: By:
 */

public class DemoMain {

    public static void main(String[] args) {
        String s = "fword123";

        if (s.matches("[1]")) {
            System.out.println("yes");
        } else {
            System.out.println("nothing");
        }

    }
}
