package com.zcy.variable;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《测试全局变量&局部变量赋值》 <Global Variable & Local Variable/>
 * @ Date: Created in 17:12 2019-07-22
 * @ Modified: By:
 * <p>
 * 局部变量:存在某个方法中的变量就叫局部变量，局部变量一旦声明就必须赋值 否则不能使用
 * <p>
 * 成员变量:存在某个类中的并且类方法外就叫成员变量。成员变量可以在类中的任何地方访问
 * <p>
 * ( 只有局部变量必须赋值才能使用 《方法内的变量 -> 局部变量》)
 */
public class VariableValue {

    //全局变量
    private static String globalVariable_NonValue;
    private static String globalVariable_HasValue = "global~Variable";
    //成员变量 (类中,且在方法外)
    String propertyVariable_NonValue;
    String propertyVariable_HasValue = "property~Variable";

    public static void main(String[] args) {
        //局部变量 (在main方法中)
        String localVariable_NonValue;
        String localVariable_HasValue = "local~Variable";

        //全局变量打印
        System.out.println("全局变量(未赋初值): " + globalVariable_NonValue);
        System.out.println("全局变量(赋初值): " + globalVariable_HasValue);
        //main函数中,局部变量打印
//        System.out.println("局部变量(未赋初值): " + localVariable_NonValue);//不赋初值根本没法调用(编译不通过)
        System.out.println("局部变量(赋初值): " + localVariable_HasValue);


        //====================成员变量 (Filed Property)=======================
        //成员变量打印
        VariableValue vv = new VariableValue();
        System.out.println("成员变量(未赋初值): " + vv.propertyVariable_NonValue);
        System.out.println("成员变量(未赋初值): " + vv.propertyVariable_HasValue);

        //普通方法中,局部变量打印
        vv.testMethod();
    }


    private void testMethod() {
        String localVariableInMeth_NonValue;
        String localVariableInMeth_HasValue = "local~Variable in method";
//        System.out.println("localVariableInMeth_NonValue" + localVariableInMeth_NonValue); //不赋初值根本没法调用(编译不通过)
        System.out.println("localVariableInMeth_HasValue" + localVariableInMeth_HasValue);
    }
}
