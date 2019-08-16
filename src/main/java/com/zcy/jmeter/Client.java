//package com.zcy.jmeter;
//
//import java.io.*;
//import java.net.Socket;
//
///**
// * @ Author: chunyang.zhang
// * @ Description: 《jmeter客户端逻辑测试-测试》
// * @ Date: Created in 16:55 2019-08-15
// * @ Modified: By:
// */
//public class Client {
//
//    public static void main(String[] args) throws IOException {
//
//        //创建客户端socket
//        Socket clientSocket = new Socket("localhost", 1234);
//
//        OutputStream outputStream = clientSocket.getOutputStream();
//        Writer writer = new BufferedWriter(new OutputStreamWriter(outputStream));
//
//
//        //编写字符串,并传输
//        String testString = "{name:爸爸,age:18,power:bullshit}";
//        writer.write(testString);
//
//        //打印服务器返回信息
//        BufferedReader response = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        String responesToString = response.readLine();
//        System.out.println("Server Response: " + responesToString);
//
//
//        //关闭输出流
//        writer.close();
//    }
//}
