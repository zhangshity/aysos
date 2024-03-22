package com.zcy.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupTest {
    public static void main(String[] args) {

        String regex = "(\\w+)(\\s\1)+";
        String text = "the little cat cat is in the hat hat hat,we like it.";

        String $1 = text.replaceAll(regex, "$1");
        System.out.println($1);





        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        matcher.find();
        int start = matcher.start();
        int end = matcher.end();
        System.out.println(start);
//        String group = matcher.group();
//        System.out.println(group);
//        String group1 = matcher.group(1);
//        System.out.println(group1);




    }
}
