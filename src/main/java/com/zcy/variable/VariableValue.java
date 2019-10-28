package com.zcy.variable;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《测试全局变量&局部变量赋值》 <Global Variable & Local Variable/>
 * @ Date: Created in 17:12 2019-07-22
 * @ Modified: By:
 */
public class VariableValue {

    //全局变量
    private static String globalVariable_NonValue;
    private static String globalVariable_HasValue = "global_value";


    public static void main(String[] args) {
        //局部变量
        String localVariable_NonValue;
        String localVariable_HasValue = "localVariable";


        //全局变量打印
        System.out.println("全局变量(未赋初值): " + globalVariable_NonValue);
        System.out.println("全局变量(赋初值): " + globalVariable_HasValue);
        //局部变量打印
//        System.out.println("局部变量(未赋初值): " + localVariable_NonValue);//不赋初值根本没法调用(编译不通过)
        System.out.println("局部变量(赋初值): " + localVariable_HasValue);

    }
}
