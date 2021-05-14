package com.zcy.basic;

public class NestedLoopBreakTest {
    public static void main(String[] args) {



        // break直接打断当前层级的[循环] , 循环内的任何代码都不在执行,  但不影响外部的代码(包括外部的循环)
        for (int i = 0; i <3 ; i++) { //1
            System.out.println("外层嵌套"+i);

            for (int j = 0; j < 5; j++) { //2
                System.out.println("中层嵌套" + j);

                for (int k = 0; k < 100; k++) { //3
                    System.out.println("内层循环" + k);
                    if (k == 2) {
                        break;
                    }
                } //3


            } //2
        } //1








    }
}
