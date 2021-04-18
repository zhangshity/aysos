package com.zcy.basic_data_type;

public class Char2Int {
    public static void main(String[] args) {
        String s = "1desc";
        String s2 = "2asc";


        System.out.println(s.charAt(0)); // 1
        System.out.println(Character.getNumericValue(s.charAt(0)) == 1); // true

        //char转换为int ,实际得到的是: 对应ascii码的值
        System.out.println((int) s2.charAt(0)); // ascii值: 50
    }
}
