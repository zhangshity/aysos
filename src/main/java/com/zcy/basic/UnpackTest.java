package com.zcy.basic;

import com.zcy.reference.Student;

import java.util.Objects;

public class UnpackTest {
    public static void main(String[] args) {


        boolean result = Objects.equals(null, 0);
        System.out.println(result);

        boolean result1 = Objects.equals(0, null);
        System.out.println(result1);

        boolean result2 = Objects.equals(0, new Integer(0));
        System.out.println(result2);

        boolean result3 = Objects.equals("SSS", "S23");
        System.out.println(result3);

        boolean result4 = Objects.equals(0, new Student());
        System.out.println(result4);

        boolean result5 = Objects.equals(null, "SSS");
        System.out.println(result5);

        System.out.println(new Integer(5).equals(6));


    }
}
