package com.zcy.collection._2_remove_FAQ;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 迭代器遍历时，修改（删除/新增）操作会出现并发修改异常，fail-fast机制。
 */
public class ForRemoveExceptionTest {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("test01");
        list.add("test02");
        list.add("test03");
        list.add("test04");
        list.add("test05");
        list.add("test06");
        list.add("test07");
        list.add("test08");
        list.add("test09");
        list.add("test10");
        System.out.println(list); //[test01, test02, test03, test04, test05, test06, test07, test08, test09, test10]


        // ============================================= 迭代器遍历 修改集合====================================================
        /**
         * 经典问题1: ForEach遍历-修改集合
         */
        // ForEach删除
        /*for (String s: list) {                 //Exception in thread "main" java.util.ConcurrentModificationException
            if (s.endsWith("06")) {            // 	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
                list.remove(s);                //	at java.util.ArrayList$Itr.next(ArrayList.java:859)
            }                                  // 	at com.zcy.collection._2_remove_FAQ.ForRemoveExceptionTest.main(ForRemoveExceptionTest.java:30)
        }
        System.out.println(list);*/
        // ForEach新增
        /*for (String s: list) {                 //Exception in thread "main" java.util.ConcurrentModificationException
            if (s.endsWith("06")) {            // 	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
                list.add("new");               //	at java.util.ArrayList$Itr.next(ArrayList.java:859)
            }                                  // 	at com.zcy.collection._2_remove_FAQ.ForRemoveExceptionTest.main(ForRemoveExceptionTest.java:38)
        }
        System.out.println(list);*/

        /**
         * 经典问题2: 迭代器遍历-修改集合
         */
        /*Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {  //Exception in thread "main" java.util.ConcurrentModificationException
            String s = iterator.next();
            if (s.endsWith("06")) {
                list.remove(s);
            }
        }*/

        /*Iterator<String> iterator2 = list.iterator();
        while (iterator2.hasNext()) {  //Exception in thread "main" java.util.ConcurrentModificationException
            String s = iterator2.next();
            if (s.endsWith("06")) {
                list.add("new");
            }
        }*/

        /**
         * 结论：
         * 迭代器遍历中，对集合进行修改会造成异常
         */


        // ============================================= 迭代器遍历 迭代器修改集合====================================================
        // 一、显式迭代器删除
        Iterator<String> iterator3 = list.iterator();
        while (iterator3.hasNext()) {  //for迭代器也可
            String s = iterator3.next();
            if (s.endsWith("06")) {
                iterator3.remove(); //迭代器删除
            }
        }
        System.out.println("迭代器删除06后：" + list); //迭代器删除06后：[test01, test02, test03, test04, test05, test07, test08, test09, test10]

        // 二、1.8新方法删除（本质也是迭代器）
        boolean isDelete = list.removeIf(e -> e.endsWith("08"));
        System.out.println("removeIf方法删除08后： 是否删除成功：" + isDelete + "  最终结果：" + list); //removeIf方法删除08后： 是否删除成功：true  最终结果：[test01, test02, test03, test04, test05, test07, test09, test10]

        // 三、stream删除
        List<String> newList = list.stream().filter(e -> !e.endsWith("03")).collect(Collectors.toList());
        System.out.println("steam filter删除03后： " + newList); //steam filter删除03后： [test01, test02, test04, test05, test07, test09, test10]

        // 四、fori删除
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).endsWith("07")) {
                list.remove(i);
            }
        }
        System.out.println("fori删除07后：" + list); //fori删除07后：[test01, test02, test03, test04, test05, test09, test10]










        // 新增
        List<String> container = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            container.add("test" + (i + 1));
        }
        System.out.println(container); // [test1, test2, test3, test4, test5, test6, test7, test8, test9, test10]

        
    }
}
