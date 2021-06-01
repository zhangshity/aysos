package com.zcy.java1_8NewFunction._3__stream;

import com.zcy.collection.Student;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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


        // =========== 归并测试 group by 2 ============
        System.out.println("=========== 归并测试 group by 2 ============");
        List<Map<String,Object>> studentList2 = Arrays.asList(
                new HashMap<String,Object>(){{put("name","zhangsan"); put("age",15);put("gender","male");}},
                new HashMap<String,Object>(){{put("name","zhangsan2"); put("age",15);put("gender","male");}},
                new HashMap<String,Object>(){{put("name","zhan12gsan"); put("age",18);put("gender","female");}},
                new HashMap<String,Object>(){{put("name","zhang333san"); put("age",15);put("gender","male");}},
                new HashMap<String,Object>(){{put("name","asdaasd"); put("age",18);put("gender","female");}},
                new HashMap<String,Object>(){{put("name","zhan3gsan"); put("age",15);put("gender","female");}},
                new HashMap<String,Object>(){{put("name","zhanasdfgsan"); put("age",21);put("gender","female");}},
                new HashMap<String,Object>(){{put("name","wer"); put("age",26);put("gender","male");}},
                new HashMap<String,Object>(){{put("name","zasangsan"); put("age",12);put("gender","male");}},
                new HashMap<String,Object>(){{put("name","zhang5555san"); put("age",88);put("gender","male");}},
                new HashMap<String,Object>(){{put("name","234"); put("age",26);put("gender","female");}},
                new HashMap<String,Object>(){{put("name","ewrwer"); put("age",16);put("gender","female");}}
        );
        Map<Object, List<Map<String, Object>>> collect2 = studentList2
                .stream()
                .parallel()
                .collect(Collectors.groupingBy(x -> ( String.valueOf(x.get("age")) + String.valueOf(x.get("gender")))));

        System.out.println(collect2);


//        {18female=[{gender=female, name=zhan12gsan, age=18}, {gender=female, name=asdaasd, age=18}],
//            21female=[{gender=female, name=zhanasdfgsan, age=21}],
//            88male=[{gender=male, name=zhang5555san, age=88}],
//            15male=[{gender=male, name=zhangsan, age=15}, {gender=male, name=zhangsan2, age=15}, {gender=male, name=zhang333san, age=15}, {gender=male, name=zhan3gsan, age=15}],
//            26female=[{gender=female, name=234, age=26}],
//            16female=[{gender=female, name=ewrwer, age=16}],
//            12male=[{gender=male, name=zasangsan, age=12}],
//            26male=[{gender=male, name=wer, age=26}]}

//        {15female=[{gender=female, name=zhan3gsan, age=15}],
//            18female=[{gender=female, name=zhan12gsan, age=18}, {gender=female, name=asdaasd, age=18}],
//            21female=[{gender=female, name=zhanasdfgsan, age=21}],
//            88male=[{gender=male, name=zhang5555san, age=88}],
//            15male=[{gender=male, name=zhangsan, age=15}, {gender=male, name=zhangsan2, age=15}, {gender=male, name=zhang333san, age=15}],
//            26female=[{gender=female, name=234, age=26}],
//            16female=[{gender=female, name=ewrwer, age=16}],
//            12male=[{gender=male, name=zasangsan, age=12}],
//            26male=[{gender=male, name=wer, age=26}]}





//				Optional.ofNullable(workFlowMapGroupByBidAndPid)
//						.filter(x -> x.containsKey(k)).map(x -> {
//					v.get(0).put("assignee", x.get(k).get(0).get("assignee"));
//					v.get(0).put("node_name", x.get(k).get(0).get("node_name"));
//					return null;
//				}).orElseGet(() -> {
//					v.get(0).put("assignee", "");
//					v.get(0).put("node_name", "");
//					return null;
//				});

    }
}
