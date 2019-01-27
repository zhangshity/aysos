package com.zcy.tools.decimal_format;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 15:49 2019-01-22
 * @ Modified: By:
 * <p>
 * <p>
 * 开发任务 逻辑测试验证
 */

public class DecimalFormatTest {

    //初始化序列值常量
    private static Integer sequence = 1;

    public static void main(String[] args) {


        List list = new ArrayList();
        list.add(new HashMap<String,String>().put("10001","asdasdas"));
        list.add(new HashMap<String,String>().put("10001","gggggggg"));
        list.add(new HashMap<String,String>().put("10001","g4444gggg"));
        list.add(new HashMap<String,String>().put("10001","g15656gggg"));
        list.add(new HashMap<String,String>().put("10001","844qwe4gggg"));
        list.add(new HashMap<String,String>().put("10002","oqwe4gggg"));
        list.add(new HashMap<String,String>().put("10002","g4ert4gggg"));
        list.add(new HashMap<String,String>().put("10002","rtq444gggg"));
        list.add(new HashMap<String,String>().put("10002","i4444gggg"));
        list.add(new HashMap<String,String>().put("10002","tqret444gggg"));

        HashMap hashMap = new HashMap();
        hashMap.put("1003", "sadasd");
        System.out.println(hashMap.get("1003"));

        System.out.println();
        //格式化Integer
        DecimalFormat decimalFormatTest = new DecimalFormat("000000000");

        for (int i = 0; i < list.size(); i++) {

            String Result = decimalFormatTest.format(sequence);
            System.out.println(list.get(i)+"|"+Result);
            sequence += 1;
        }


    }


}
