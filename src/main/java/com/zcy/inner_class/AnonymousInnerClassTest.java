package com.zcy.inner_class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 《匿名内部类的测试》
 *
 * @author Allen.C.Y.Zhang
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {

        //-----------------------------------------------------------------------
        // i.g. one step create 一步创建
        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("典型匿名内部类");
            }
        };


        // means the same way. 等价于相同写法 two step create 二步创建
        class myRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println("手动创建的类");
            }
        }
        Runnable runnable = new myRunnable();


        //-----------------------------------------------------------------------
        System.out.println("-----------------------------------------------------------------------");
        // 集合的应用 list
        // one step crete and assignment
        List<String> anonymousList = new ArrayList<String>() {
            // 内部类变量
            int i = 666;

            // 内部类代码块
            {
                for (int j = 0; j < 10; j++) {
                    add("value" + j);
                }
                System.out.println("匿名内部类代码块" + i);
                this.print_i();
            }

            // 内部类方法
            private void print_i() {
                System.out.println(i);
            }
        };
        System.out.println(anonymousList); // 打印 [value0, value1, value2, value3, value4, value5, value6, value7, value8, value9]


        // means the same way. two step crete and assignment
        class myList extends ArrayList<String> {
            // 变量
            int i = 888;

            // 代码块
            {
                for (int j = 0; j < 10; j++) {
                    add("value" + j);
                }
                System.out.println("手动创建类代码块" + i);
                this.print_i();
            }

            // 方法
            private void print_i() {
                System.out.println(i);
            }
        }

        List<String> list = new myList();

        System.out.println(list);// 打印 [value0, value1, value2, value3, value4, value5, value6, value7, value8, value9]




        //-----------------------------------------------------------------------
        System.out.println("-----------------------------------------------------------------------");
        // 集合的应用 map
        // one step crete and assignment
        Map<String, String> anonymousMap = new HashMap<String, String>(64) {
            // 内部类变量
            int i = 666;

            // 内部类代码块
            {
                for (int j = 0; j < 10; j++) {
                    put("key" + i, "value" + j);
                }
                System.out.println("匿名内部类代码块" + i);
                this.print_i();
            }

            // 内部类方法
            private void print_i() {
                System.out.println(i);
            }
        };
        System.out.println(anonymousMap); // 打印


        // means the same way. two step crete and assignment
        class myMap extends HashMap<String, String> {
            // 变量
            int i = 888;

            // 代码块
            {
                for (int j = 0; j < 10; j++) {
                    put("key" + i, "value" + j);
                }
                System.out.println("手动创建类代码块" + i);
                this.print_i();
            }

            // 构造方法
//            public HashMap() {
//            }


            // 方法
            private void print_i() {
                System.out.println(i);
            }
        }

        Map<String, String> map = new myMap();

        System.out.println(map);// 打印 [value0, value1, value2, value3, value4, value5, value6, value7, value8, value9]
    }
}
