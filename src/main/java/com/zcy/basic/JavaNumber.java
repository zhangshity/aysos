package com.zcy.basic;

public class JavaNumber {
    public static void main(String[] args) {

        int binary = 0b1001;        //二进制定义 (前缀0b、0B)
        int octonary = 0741;        //八进制定义 (前缀0)
        int decimal = 13;           //十进制定义 (默认)
        int hexadecimal = 0xA554E;  //十六进制定义 (前缀0x、0X)

        System.out.println("二进制: " + binary +
                "\n八进制: " + octonary +
                "\n十进制: " + decimal +
                "\n十六进制: " + hexadecimal);

    }
}
