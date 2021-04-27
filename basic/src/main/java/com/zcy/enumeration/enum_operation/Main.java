package com.zcy.enumeration.enum_operation;

public class Main {
    public static void main(String[] args) {


        System.out.println(GenderEnum.parse(GenderEnum.MALE.getCode()));
        System.out.println(GenderEnum.parse(3));

        System.out.println("-------------------------------------");

        System.out.println(GenderEnum.parse(GenderEnum.MALE));
        System.out.println(GenderEnum.parse(GenderEnum.FEMALE));


    }
}
