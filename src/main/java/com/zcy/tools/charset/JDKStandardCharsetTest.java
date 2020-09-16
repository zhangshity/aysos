package com.zcy.tools.charset;

import java.nio.charset.StandardCharsets;

public class JDKStandardCharsetTest {
    public static void main(String[] args) {


        System.out.println(StandardCharsets.UTF_8); //UTF-8
        System.out.println(StandardCharsets.UTF_8.toString()); //UTF-8
        System.out.println(StandardCharsets.UTF_8.name()); //UTF-8
        System.out.println(StandardCharsets.UTF_8.displayName()); //UTF-8


    }
}
