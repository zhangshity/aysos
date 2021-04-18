package com.zcy.collection.list;

import java.util.ArrayList;

public class ListMethodTest {
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList() {{
            add("1");
            add("2");
            add("3");
        }};
        arrayList.remove("1");
        System.out.println(arrayList);


    }
}
