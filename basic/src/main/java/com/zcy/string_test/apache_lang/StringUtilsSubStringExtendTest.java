package com.zcy.string_test.apache_lang;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsSubStringExtendTest {
    public static void main(String[] args) {

        // 切分例子
        String fileName = "1000000056_fucku_20210625.txt";

        // java8原生 =======================================================================
        //前缀
        String prefix = fileName.substring(0, fileName.indexOf("."));
        System.out.println(prefix); //1000000056_fucku_20210625

        //后缀
        String suffix = fileName.substring(fileName.indexOf("."));
        System.out.println(suffix); //.txt

        //apache common lang3 =======================================================================
        // 前缀 method1
        String prefix2 = StringUtils.substringBetween(fileName, "", ".");
        System.out.println(prefix2); //1000000056_fucku_20210625

        // 前缀 method2
        String prefix3 = StringUtils.substringBefore(fileName, ".");
        System.out.println(prefix3); //1000000056_fucku_20210625

        //后缀2
        String suffix2 = StringUtils.substringAfterLast(fileName, ".");
        System.out.println(suffix2); //txt

        //后缀3
        String suffix3 = StringUtils.substringAfter(fileName, ".");
        System.out.println(suffix3); //txt
    }
}
