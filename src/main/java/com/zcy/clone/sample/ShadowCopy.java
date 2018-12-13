package com.zcy.clone.sample;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 10:12 2018/12/13
 * @ Modified: By:
 */

public class ShadowCopy {

    public static void main(String[] args) {
        Professor professor1 = new Professor();
        professor1.setName("龚嘉阳教授");
        professor1.setAge(23);

        Student student1 = new Student();
        student1.setName("小明");
        student1.setAge(11);
        student1.setProfessor(professor1);

        System.out.println(student1);


        Student student2 = (Student) student1.clone();//学生2是平行时空的学生1,但是他换了个傻逼教授
        Professor professor2 = student2.getProfessor();
        professor2.setName("傻逼教授");
        professor2.setAge(44);
        student2.setProfessor(professor2);

        System.out.println("复制后学生1："+student1);
        System.out.println("复制后得到学生2：" + student2);

        //把clone后的student2,中的教授改了。发现student1的教授也改了。
        //此为浅克隆(shadow clone):只clone 引用(reference)。

        //要想不出现上述问题。可深克隆(deep clone):既clone 引用(reference),又clone 实例对象(instance)
        //方法即Professor 的注释掉的那堆代码
    }
}
