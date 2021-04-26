package com.zcy.basic;


/**
 * 钱海网络傻逼开发，许四郎的代码 - NPE自己看不懂，菜还逼
 */
public class UnpackException {
    public static void main(String[] args) {

        Student student = new Student();
        student.setName("Fuck-OceanPayment-Zilean");


        int i = 10;
        if (student.getAge() == i) {
            System.out.println("哈哈哈");
        } else {
            System.out.println("呜呜呜");
        }




    }
}

class Student{
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
