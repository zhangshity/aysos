package com.zcy.basic_data_type;

public class __1_Number {
    public static void main(String[] args) {

        int binary = 0b1001;        //二进制定义 (前缀0b、0B)
        int octonary = 0741;        //八进制定义 (前缀0)
        int decimal = 13;           //十进制定义 (默认)
        int hexadecimal = 0xA554E;  //十六进制定义 (前缀0x、0X)

        System.out.println("二进制: " + binary +
                "\n八进制: " + octonary +
                "\n十进制: " + decimal +
                "\n十六进制: " + hexadecimal);

        //===================================================
        int i = 231;
        System.out.println("二进制显示 >" + Integer.toBinaryString(i));
        System.out.println("八进制显示 >" + Integer.toOctalString(i));
        System.out.println("十六进制显示 >" + Integer.toHexString(i));

        System.out.println("任意进制转换显示 >" + Integer.toString(257, 34)); //radix默认2-36

        //=========String转换成整型==============================
        String s = "1234";
        int parseInt = Integer.parseInt(s, 10);
        Integer valueOf = Integer.valueOf(s, 10);

        System.out.println("String转为int >" + parseInt + "\nString转为Integer >" + valueOf);

    }
}
