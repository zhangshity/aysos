package com.zcy.basic;

public class IfBreakTest {

    String flag1 = "a";
    String flag2 = "b";

    public static void main(String[] args) {
        IfBreakTest instance = new IfBreakTest();

        while (true) {
            if (instance.flag1.equals("a")) {
                System.out.println("外层if打印！开始");
                if (instance.flag2.equals("b")) {
                    System.out.println("内层if打印！");
                    break; // 打破循环
                }
                System.out.println("外层if打印！结束");
            }
        }
    }
}
