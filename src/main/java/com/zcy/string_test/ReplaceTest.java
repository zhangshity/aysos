package com.zcy.string_test;

public class ReplaceTest {
    public static void main(String[] args) {

        /**
         * replace/replaceAll/replaceFirst
         */
        String template = "@name is my son,and @number bullshit???? ";
        System.out.println(template + "\n-------------------------------------------------------");


        String replace = template.replace("@name", "[puppy]").replace("@number", "[+1123565416]").replace("123", "456");
        System.out.println(replace);
        


        String replaceAll = template.replaceAll("@name", "[replaceAll]").replaceAll("@number", "[+1123565416]");
        System.out.println(replaceAll);

        String replaceAll2 = template.replaceAll("@", "[replaceAll]");
        System.out.println(replaceAll2);



        String replaceFirst = template.replaceFirst("@", "[replaceFirst]");
        System.out.println(replaceFirst);

    }
}
