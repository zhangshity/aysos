package com.zcy.file_io;

import java.io.*;

/**
 * @ Author: chunyang.zhang
 * @ Description: 最简单的文件读写
 * @ Date: Created in 14:58 2019-05-16
 * @ Modified: By:
 */
public class Simple_Demo {

    /**
     * 字节流读文件(InputStream)
     *
     * @param filePathAndName
     */
    public void readFile(String filePathAndName) {

        InputStream inputStream = null;
        try {
            //读取文件内容 > 字节流
            inputStream = new FileInputStream(new File(filePathAndName));

            //读取字节流中的内容
            //方法0. 不知道文件大小,无法定义数组
            byte[] byteArrayWithoutLen = new byte[inputStream.available()];
            int len0 = inputStream.read(byteArrayWithoutLen);
            String result0 = new String(byteArrayWithoutLen, 0, byteArrayWithoutLen.length);
            System.out.println("Method0. =  >>>" + result0 + "\n");

            //方法1. InputStream自有方法直接输出到Byte数组
            byte[] byteArray = new byte[1024];
            int len = inputStream.read(byteArray);
            String result1 = new String(byteArray, 0, len);
            System.out.println("Method1. =  >>>" + result1 + "\n");

            //方法2.循环输出(实际是读取单个字节)
            byte[] byteContainer = new byte[1024];
            //循环读取 (-1为结束)
            int temp = 0;
            int index = 0;
            while ((temp = inputStream.read()) != -1) {
                byteContainer[index++] = (byte) temp;
            }
            String reslut = new String(byteContainer, 0, index);
            System.out.println("Method3.   >>>" + reslut + "\n");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字节流写文件(OutputStream)
     *
     * @param filePathAndName
     */
    public void writeFile(String filePathAndName) {

        File file = new File(filePathAndName);
        if (!file.exists()) {
            file.mkdirs();
        }

        OutputStream outputStream = null;
        try {
            //定义输出流
            outputStream = new FileOutputStream(file);

            //输出内容搞成 字节数组
            String outMsg = "123asd阿吧看";
            byte[] byteArray = outMsg.getBytes();
            //输出字节数组
            outputStream.write(byteArray);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 字符流读文件(Reader)
     *
     * @param filePathAndName
     */
    public void readFileByReader(String filePathAndName) {
        Reader reader = null;
        try {
            reader = new FileReader(new File(filePathAndName));
            char[] charArray = new char[1024];
            int len = reader.read(charArray);
            String result = new String(charArray, 0, len);

            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流写文件(Writer)
     *
     * @param filePathAndName
     */
    public void writeFileByWriter(String filePathAndName) {

        Writer writer = null;
        try {
            writer = new FileWriter(new File(filePathAndName));
            String msg = "asd123撒旦";
            writer.write(msg);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
