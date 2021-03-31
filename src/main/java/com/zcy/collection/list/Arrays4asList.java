package com.zcy.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays4asList {
    public static void main(String[] args) {


        List<String> list = Arrays.asList("asd", "123", "yyyy");
        System.out.println(list);

//        list.add("???");
//        list.remove("123");
        // Exception in thread "main" java.lang.UnsupportedOperationException
        // 	at java.util.AbstractList.add(AbstractList.java:148)
        // 	at java.util.AbstractList.add(AbstractList.java:108)
        // 	at com.zcy.collection.list.Arrays4asList.main(Arrays4asList.java:13)
//        System.out.println(list);


        List<String> realList = new ArrayList<>(list);
        System.out.println(realList);

        realList.add("???");
        System.out.println(realList);
        realList.remove("123");
        System.out.println(realList);

    }
}
