package com.zcy.serialize.example_1;

import java.io.*;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《序列化测试》
 * @ Date: Created in 10:41 2019-07-19
 * @ Modified: By:
 */
public class DemoMain {

    public static final String filePathAndName = "/Users/zhangchunyang/Documents/IdeaProjects/aysos/src/main/resources/serializable/temp";

    public static void main(String[] args) {

        Student student = new Student();
        student.setId(002);
        student.setName("Thor");
        student.setGender("male");
        System.out.println("original student object" + student);

        System.out.println(">>> 序列化开始");
        writeObject(student);

        Student student1 = new Student();
        student1 = (Student) readObject(filePathAndName);
        System.out.println("student object deserialize from file" + student1);

    }

    /**
     * 写对象到文件
     *
     * @param object
     */
    public static void writeObject(Object object) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(filePathAndName));
            objectOutputStream.writeObject(object);
            System.out.println("> > > 序列化完成 - ");
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读文件中的对象
     *
     * @param file
     * @return
     */
    public static Object readObject(String file) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Object o = objectInputStream.readObject();
            return o;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
