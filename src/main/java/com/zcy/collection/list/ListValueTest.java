package com.zcy.collection.list;

import com.zcy.collection.Student;

import java.util.ArrayList;
import java.util.List;

public class ListValueTest {
    public static void main(String[] args) {

        List list = new ArrayList();
        System.out.println(list.size());//0
        System.out.println(list.isEmpty()); //true


        list.add(new Student());
        System.out.println(list.size());//1
        list.add(null);
        System.out.println(list.size());//2
        System.out.println(list); //[Student{name='null', age=0, gender='null'}, null]

        list.set(1, "2号元素");
        System.out.println(list.size()); //2
        System.out.println(list); //[Student{name='null', age=0, gender='null'}, 2号元素]


        List list2 = new ArrayList();
        list.add(null);
        System.out.println(list.isEmpty()); //false
    }
}
