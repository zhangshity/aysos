package com.zcy._1FAQ.newcoder;

import java.util.*;

public class RecodeHuawei {
    public static void main(String[] args) {
        /**
         * 统计字母在字符串中的出现次数(区分大小写,数字不统计)
         */

        Map<String, Integer> mapContainer = new Hashtable<>();//存储输入值的map容器
        int counter = 0;//统计计数器
        List<Map.Entry<String, Integer>> listCotainer = new ArrayList<>();//排序list容器

        //控制台循环输入
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String scannerString = in.nextLine();

            // 1.读取判读输入值，并放入map容器保存
            String split[] = scannerString.split("");
            for (int i = 0; i < split.length; i++) {
                if (!mapContainer.containsKey(split[i]) && split[i].matches("[0-9]")) {
                    for (int j = 0; j < split.length; j++) {
                        if (split[i].equals(split[j])) {
                            counter++;
                        }
                    }
                    mapContainer.put(split[i], counter);
                    counter = 0;
                }
            }

            // 2.map容器中的键值对按value的值从大到小重新排列
            listCotainer.addAll((mapContainer.entrySet()));
            Collections.sort(listCotainer, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });

            // 3.输出容器转换排序后的结果
            for (Map.Entry<String, Integer> entry : listCotainer) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }

            // 4.结束后清空map容器和转换容器list(方便循环再次使用)
            mapContainer.clear();
            listCotainer.clear();
        }

    }
}
