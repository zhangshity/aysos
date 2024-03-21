package com.zcy._1FAQ;

import java.util.*;

public class DistinctTest {
    public static void main(String[] args) {
        //数组去重，重复的元素保留最后一个
        //输入：[a, b, c, c, b, d, c]
        //输出：[a, b, d, c]

        String[] input = new String[]{"a", "b", "c", "c", "b", "d", "c"};
        //String[] distinct = distinct(input);
        //String[] distinct = distinctByMap(input); // [a, b, c, d]


        String[] distinct = distinctWithoutMap(input);

        System.out.println(Arrays.toString(distinct));


    }


    // 利用java的map去重
    public static String[] distinctByMap(String[] input) {
        // map去重
        Map<String, Integer> distinctMap = new LinkedHashMap<>(); //保证顺序
        for (int i = 0; i < input.length; i++) {
            distinctMap.put(input[i], i); // <数组值,数组下标> 重复值会覆盖
        }

        // map keySet(数组值列表) 转数组
        String[] result = new String[distinctMap.size()];
        int i = 0;
        for (Map.Entry<String, Integer> kv : distinctMap.entrySet()) {
            result[i++] = kv.getKey();
        }
        return result;
    }


    // 利用java的list去重
    public static String[] distinctByList(String[] input) {
        // list去重
        return null;
    }

    public static String[] distinctWithoutMap(String[] input) {
        List<String> distinctList = new ArrayList<>();
        for (int i = input.length - 1; i >= 0; i--) {
            if (!distinctList.contains(input[i])) {
                distinctList.add(0, input[i]);
            }
        }
        return distinctList.toArray(new String[0]);
    }




        public static String[] distinct(String[] input) {
        // 1.API
//        return Arrays.stream(input).distinct().collect(Collectors.toList()).toArray(new String[]{});


        // 2.DIY
        // 1）逐个遍历比较
//        List<String> result = new ArrayList<>(input.length);
////        String[] result = new String[]{}; // TODO长度
//        for (int i = 0; i < input.length; i++) {
//            int repeatIndex = i;
//            for (int j = i + 1; j < input.length - 1; j++) {
//                if (input[repeatIndex].equals(input[j])) { // 重复
//                    // 删掉 copy
//                    repeatIndex = j;
//                }
//            }
//            if (i != repeatIndex) {
//                result.add(input[repeatIndex]); // 这里再遍历到还会加进去
//            } else {
//                result.add(input[i]);
//            }
//        }
//        return result.toArray(new String[]{});



        // 遍历逐个比较，重复的赋值临时变量寄存。
        // 删除

            return null;
    }




}

