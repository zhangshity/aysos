package com.zcy.serialize.example_1;

import java.io.*;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《序列化测试》
 * @ Date: Created in 10:41 2019-07-19
 * @ Modified: By:
 */
public class DemoMainWrite {

    public static final String filePathAndName = "/Users/zhangchunyang/Documents/IdeaProjects/aysos/src/main/resources/serializable/temp.ser";

    public static void main(String[] args) {

        Student student = new Student();
        student.setId(002);
        student.setName("Thor");
        student.setGender("male");
        student.setScore(90);
        System.out.println("original student object: " + student);

        System.out.println(">>> 序列化开始 >>>");
        String result = writeObject(student);
        System.out.println(">>> 序列化结果 >>>" + " : " + result);
    }

    /**
     * 写对象到文件
     *
     * @param object
     */
    private static String writeObject(Object object) {
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePathAndName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            //写入文件对象
            objectOutputStream.writeObject(object);
            return "写入文件成功！";
        } catch (IOException e) {
            e.printStackTrace();
            return "写入文件失败！";
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
