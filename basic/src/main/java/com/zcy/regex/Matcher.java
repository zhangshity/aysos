package com.zcy.regex;

/**
 * @ Author: chunyang.zhang
 * @ Description:  《正则表达式试验》
 * @ Date: Created in 00:54 2019/11/3
 * @ Modified: By:
 */

public class Matcher {
    public static void main(String[] args) {

        String input = "1f23ab0c";
        String split[] = input.split("");
        for (int i = 0; i < split.length; i++) {
            Boolean result = split[i].matches("[0-9]");
            System.out.println(split[i] + " >>> " + result);
        }


    }

}
