package com.zcy.newcoder;

import java.util.*;

/**
 * @ Author: chunyang.zhang
 * @ Description:    统计字母在字符串中的出现次数(区分大小写,数字不统计)
 * @ Date: Created in 00:36 2019/10/30
 * @ Modified: By:
 * <p>
 * a=6
 * c=5
 * e=2
 */
public class Huawei {
    //统计字母在字符串中的出现次数(区分大小写)
    public static void main(String[] args) {


        int counter = 0;
//        StringBuffer afterCountContainer = new StringBuffer();//统计过暂存，防止重复统计
//        List<String> afterCountContainer = new ArrayList<>();//统计过暂存，防止重复统计
        Map<String, Integer> afterCountContainer = new HashMap<>();//统计过暂存，防止重复统计

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String scanString = in.nextLine();
//            System.out.println(">>> "+ scanString);
            String split[] = scanString.split("");
//            for (int i = 0; i < split.length; i++) {
////                System.out.println(split[i]);
//                for (int j = 0; j < split.length; j++) {
//                    if (!afterCountContainer.containsKey(split[i]) && split[i].equals(split[j])) {//TODO 数字不统计！记得修订( if(split[i]不是数字){} )
//                        counter++;
//                    }
//                }
//                if (!afterCountContainer.containsKey(split[i])) {
//                    afterCountContainer.put(split[i], counter);
//                }
//                counter = 0;
//            }

            for (int i = 0; i < split.length; i++) {
                if (!afterCountContainer.containsKey(split[i]) && !split[i].matches("[0-9]")) {
                    for (int j = 0; j < split.length; j++) {
                        if (split[i].equals(split[j])) {
                            counter++;
                        }
                    }
                    afterCountContainer.put(split[i], counter);
                    counter = 0;
                }

            }


            //遍历存储的HashMap
            for (String key : afterCountContainer.keySet()) {
                System.out.println(key + "=" + afterCountContainer.get(key));
            }
            //每次清空map容器
            afterCountContainer.clear();
        }


    }
}



