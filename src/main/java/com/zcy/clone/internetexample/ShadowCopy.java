package com.zcy.clone.internetexample;

import com.zcy.clone.sample.Professor;
import com.zcy.clone.sample.Student;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《浅克隆》<ShadowCopy/>
 * @ Date: Created in 14:47 2019-07-29
 * @ Modified: By:
 * <p>
 * 参考对应Github文档:
 * https://github.com/zhangshity/technote/blob/master/Java/clone()%E6%96%B9%E6%B3%95.md
 */
public class ShadowCopy {

    public static void main(String[] args) {
        //初始化教授对象并赋值
        Professor p1 = new Professor();
        p1.setName("Professor Zhang");
        p1.setAge(30);

        //初始化学生并赋值
        Student s1 = new Student();
        s1.setName("xiao ming");
        s1.setAge(18);
        s1.setProfessor(p1);

        System.out.println(s1);
        try {
            //clone Student类，修改Professor类属性
            Student s2 = (Student) s1.clone();
            s2.getProfessor().setName("Professor Li");
            s2.getProfessor().setAge(45);

//            Professor p2 = s2.getProfessor();
//            p2.setName("Professor Li");
//            p2.setAge(45);
//            s2.setProfessor(p2); //脱了裤子放屁

            System.out.println("复制后的：s1 = " + s1);
            System.out.println("复制后的：s2 = " + s2);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
