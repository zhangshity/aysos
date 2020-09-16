package com.zcy.log;

import com.zcy.reference.Student;

import java.util.Arrays;

public class Sout {
    public static void main(String[] args) {


        Student[] students = {new Student("AAA", 26), new Student("zHANG SAN", 18)};
        String[] sArray = {"123", "12312", "adeas】", "奥术大师"};

        System.out.println(students);
        System.out.println(sArray);
        System.out.println(Arrays.toString(students));
        System.out.println(Arrays.asList(students));
        System.out.println(Arrays.toString(sArray));

        /**
         * 结论 - 数组不能直接打印
         * 集合可以直接打印
         */





    }
}
