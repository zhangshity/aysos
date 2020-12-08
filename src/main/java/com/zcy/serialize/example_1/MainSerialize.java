package com.zcy.serialize.example_1;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《序列化测试》
 * @ Date: Created in 10:41 2019-07-19
 * @ Modified: By:
 */
public class MainSerialize {

    public static final String filePathAndName = "src/main/resources/serializable/temp.ser";

    public static void main(String[] args) {

        Student student = new Student();
        student.setId(002);
        student.setName("Thor");
        student.setGender("male");
        student.setScore(90);
        System.out.println("original student object: " + student);


        // ============= 写文件(序列化) =============
        System.out.println("============= 读文件(反序列化) =============");
        System.out.println(">>> 序列化开始 >>>");
        String result = writeObject(student);
        System.out.println(">>> 序列化结果 >>>" + " : " + result);


        // ============= 读文件(反序列化) =============
        System.out.println("============= 读文件(反序列化) =============");
        Student readStudentObject = (Student) readObject(filePathAndName);
        System.out.println("student object deserialize from file: " + readStudentObject);
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
