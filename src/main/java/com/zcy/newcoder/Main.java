package com.zcy.newcoder;

import java.util.*;

public class Main {
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
            for (int i = 0; i < split.length; i++) {
//                System.out.println(split[i]);
                for (int compare = 0; compare < split.length; compare++) {
                    if (!afterCountContainer.containsKey(split[i]) && split[i].equals(split[compare])) {//TODO 数字不统计！记得修订( if(split[i]不是数字){} )
                        counter++;
                    }
                }
                if (!afterCountContainer.containsKey(split[i])) {
                    afterCountContainer.put(split[i], counter);
                }
                counter = 0;
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
