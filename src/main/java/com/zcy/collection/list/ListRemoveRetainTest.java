package com.zcy.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListRemoveRetainTest {
    public static void main(String[] args) {


        List<String> listA_02 = new ArrayList<>();
        listA_02.add("A");
        listA_02.add("B");
        listA_02.add("C");
        listA_02.add("D");


        List<String> listB_02 = new ArrayList<>();
        listB_02.add("B");
        listB_02.add("C");


        List<String> differenceSet = new ArrayList(listA_02);
        List<String> intersectionSet = new ArrayList(listA_02);

        differenceSet.retainAll(listB_02);
        intersectionSet.removeAll(listB_02);


        System.out.println(differenceSet);
        System.out.println(intersectionSet);

    }
}
