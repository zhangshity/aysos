package com.zcy.clone.myexample;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《克隆测试主方法》<Clone/>
 * @ Date: Created in 10:12 2018/12/13
 * @ Modified: By:
 * <p>
 * 参考对应Github文档:
 * https://github.com/zhangshity/technote/blob/master/Java/clone()%E6%96%B9%E6%B3%95.md
 */

public class CloneMainDemo {

    public static void main(String[] args) {
        //初始化Student、professsor并赋值
        Professor professor1 = new Professor();
        professor1.setName("龚嘉阳教授");
        professor1.setAge(23);

        Student student1 = new Student();
        student1.setName("小明");
        student1.setAge(11);
        student1.setProfessor(professor1);

        //打印赋值结果
        System.out.println(student1);
        //==== 克隆Start ====
        Student student2 = (Student) student1.clone();//学生2是平行时空的学生1,但是他换了个傻逼教授
        student2.setName("无名");
        student2.setAge(03);
        student2.getProfessor().setName("傻逼教授");
        student2.getProfessor().setAge(44);
        //==== 克隆End ====

        System.out.println("Clone()后原学生1：" + student1);
        System.out.println("Clone()后学生2：" + student2);


        //把clone后的student2,中的教授改了。发现student1的教授也改了。
        //此为浅克隆(shadow clone):只clone 引用(reference)。

        //要想不出现上述问题。可深克隆(deep clone):既clone 引用(reference),又clone 实例对象(instance)
        //方法即Professor 的注释掉的那堆代码
    }
}
