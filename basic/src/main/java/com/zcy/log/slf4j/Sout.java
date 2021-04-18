package com.zcy.log.slf4j;

import com.zcy.reference.Student;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sout {



    public static void main(String[] args) {


        Student[] students = {new Student("AAA", 26), new Student("zHANG SAN", 18)};
        String[] sArray = {"123", "12312", "adeas】", "奥术大师"};

        System.out.println(students);
        System.out.println(sArray);
        System.out.println(Arrays.toString(students));
        System.out.println(Arrays.asList(students));
        System.out.println(Arrays.toString(sArray));

        /**
         * 结论 - 数组不能直接打印
         * 集合可以直接打印
         */


        //=========================================================================
        System.out.println("=========================================================================");
        String a = "fail";
        String b = "capture";
        Map map = new HashMap() {{
            put("123", "asdsa");
            put("45", "asd");
        }};

        noReconciliation4InvalidParam("订单: 1000065641145对账,", "获取ICBC响应嘻嘻:", "错误银行响应状态(STATUS):", map.toString(), ",错误银行响应状态(STATUS):", b);


    }



    public static void noReconciliation4InvalidParam(String tradeNo, String bankCode, String... params) {
        System.out.println("11111     " + tradeNo + bankCode + String.join("", params));
    }
}
