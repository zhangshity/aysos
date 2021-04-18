package com.zcy.java1_8NewFunction._3__stream;

import com.zcy.collection.Student;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListStreamTest {
    public static void main(String[] args) {

        Stream<Integer> stream = Stream.empty();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i + RandomStringUtils.randomAlphanumeric(10));
        }

        List<String> newList = list.stream().filter(x -> x.contains("A")).map(String::trim).collect(Collectors.toList());

        System.out.println(list);
        System.out.println(newList);



        // =========== 归并测试 group by ============
        System.out.println("=========== 归并测试 group by ============");
        List<Student> studentList = Arrays.asList(new Student("zhangsan", 15, "male"), new Student("zhangsan2", 15, "male"),
                new Student("zhan12gsan", 18, "female"), new Student("zhang333san", 15, "male"),
                new Student("asdaasd", 18, "female"), new Student("zhan3gsan", 15, "male"),
                new Student("zhanasdfgsan", 21, "female"), new Student("wer", 26, "male"),
                new Student("zasangsan", 12, "male"), new Student("zhang5555san", 88, "male"),
                new Student("234", 26, "female"), new Student("ewrwer", 16, "female"));

        // 年龄分组
        Map<Integer, List<Student>> collectGroupByAge = studentList.stream().parallel().collect(Collectors.groupingBy(Student::getAge));
        System.out.println(collectGroupByAge);

        // 性别分组
        Map<Object, List<Student>> collectGroupByGender = studentList.stream().parallel().collect(Collectors.groupingBy((t) -> {
            return t.getGender();
        }));
        System.out.println(collectGroupByGender);

        // 空List测试
        List<Student> emptyStudentList = new ArrayList<>();
        Map<Integer, List<Student>> collect = emptyStudentList.stream().parallel().collect(Collectors.groupingBy(Student::getAge));
        System.out.println("集合为空？ " + emptyStudentList.isEmpty() + " .  流计算结果" + collect);

    }
}
