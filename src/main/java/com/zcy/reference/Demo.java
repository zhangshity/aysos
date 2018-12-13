package com.zcy.reference;

public class Demo {


    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("学生1");
        s1.setAge(11);
        System.out.println("s1= " + s1);

        Student s2 = s1;

        System.out.println("s2= " + s2);

        //编译通过且执行成功。证明引用可传递赋值，且两个引用指向同一个对象
    }
}
