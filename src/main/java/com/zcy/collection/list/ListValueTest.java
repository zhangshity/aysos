package com.zcy.collection.list;

import com.zcy.collection.Student;

import java.util.ArrayList;
import java.util.List;

public class ListValueTest {
    public static void main(String[] args) {

        List list = new ArrayList();
        System.out.println(list.size());//0            源码{return size;}
        System.out.println(list.isEmpty()); //true     源码{return size == 0;}


        list.add(new Student());
        System.out.println(list.size());//1
        list.add(null);
        System.out.println(list.size());//2
        System.out.println(list); //[Student{name='null', age=0, gender='null'}, null]

        System.out.println("=========== List的 set()方法 ================"); //返回添加之前的值
        Object o = list.set(1, "2号元素");                             //源码{... E oldValue = elementData(index); elementData[index] = element; return oldValue;}
        System.out.println("set()方法返回值 " + o); //null
        System.out.println("get(1)得到的值 " + list.get(1)); //2号元素
        System.out.println(list.size()); //2
        System.out.println(list); //[Student{name='null', age=0, gender='null'}, 2号元素]




        System.out.println("=========== List all(null) 添加空值测试 ======================="); //null依然占地
        List list2 = new ArrayList();
        list2.add(null);
        System.out.println(list2);  //[]
        System.out.println(list.isEmpty()); //false
        list2.add("第二个值");
        System.out.println(list2);
        System.out.println("get(0) " + list2.get(0)); //null
        System.out.println("get(1) " + list2.get(1)); //第二个值




        System.out.println("======= List的初始化测试 ========");
        List list3 = new ArrayList();
        List list4 = null;
        System.out.println("list3= " + list3); //[]
        System.out.println("list4= " + list4); //null

        System.out.println(list3 == null); //false
        System.out.println(list4 == null); //true
        System.out.println(list3.isEmpty()); //true             isEmpty() ->源码 {return size == 0;}
        System.out.println(list4.isEmpty()); //空指针异常        isEmpty() ->源码 {return size == 0;}
    }
}
