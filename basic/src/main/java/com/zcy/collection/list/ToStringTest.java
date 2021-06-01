package com.zcy.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ToStringTest {
    public static void main(String[] args) {

        List<String> unionKey = new ArrayList<>();
        unionKey.add("111121");
        unionKey.add("ww2222");
        unionKey.add("333333");
        unionKey.add("444444");
        unionKey.add("555555");
        unionKey.add("666666");

        System.out.println(unionKey.toString());

        System.out.println(String.join(",",unionKey));

//        System.out.println(new StringJoiner());


    }
}
