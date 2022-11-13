package com.zcy.java1_8NewFunction._3__stream;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class List_Null_And_Empty_Test {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff");

        // filter没有符合条件： 返回空集合,不会NPE！
        List<String> filterResult1 = list.stream().filter(each -> each.startsWith("x"))
                .collect(Collectors.toList());
        System.out.println("过滤结果1："+ filterResult1 + ", 结果size："+ filterResult1.size()); //过滤结果1：[], 结果size：0

        //groupingBy一个空List：也返回一个空集合,不会NPE
        List<Student> list2 = new ArrayList<>();
        Map<Integer, List<Student>> groupByResult1 = list2.stream().collect(Collectors.groupingBy(Student::getAge));
        System.out.println("分组空集合：" + groupByResult1); //分组空集合：{}

        List<Student> students = groupByResult1.get("123");
        System.out.println(students.size()); //NPE
        System.out.println(students.get(0)); //NPE

    }
}



@Data
class Student{
    private String name;
    private Integer age;
    private String gender;
}
