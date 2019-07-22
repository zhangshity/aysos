package com.zcy.serialize.example_1;

import java.io.*;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《序列化测试》
 * @ Date: Created in 10:41 2019-07-19
 * @ Modified: By:
 */
public class DemoMainRead {

    private static final String filePathAndName = "/Users/zhangchunyang/Documents/IdeaProjects/aysos/src/main/resources/serializable/temp.ser";

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {

        Student readStudentObject = (Student) readObject(filePathAndName);
        System.out.println("student object deserialize from file: " + readStudentObject);

    }

    /**
     * 读文件中的对象
     *
     * @param file
     * @return
     */
    private static Object readObject(String file) {
        ObjectInputStream objectInputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            //读取文件并返回
            Object o = objectInputStream.readObject();
            return o;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
