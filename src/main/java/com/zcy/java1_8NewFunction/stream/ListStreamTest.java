package com.zcy.java1_8NewFunction.stream;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
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


    }
}
