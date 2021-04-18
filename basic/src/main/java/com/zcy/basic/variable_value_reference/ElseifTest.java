package com.zcy.basic.variable_value_reference;

public class ElseifTest {

    public static void main(String[] args) {

        int result = 0, flag = -1;

        if (flag == result) {
            System.out.println("if");
        } else if (flag < result) {
            System.out.println("elseif");
        }

        //可以没有else

    }
}
