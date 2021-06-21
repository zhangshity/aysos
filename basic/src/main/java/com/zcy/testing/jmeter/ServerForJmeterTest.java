package com.zcy.testing.jmeter;//package com.com.zcy.testing.jmeter;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.ServerSocket;
//import java.net.Socket;
//
///**
// * @ Author: chunyang.zhang
// * @ Description: 《Jmeter测试-后端处理小程序》
// * @ Date: Created in 16:44 2019-08-15
// * @ Modified: By:
// */
//public class ServerForJmeterTest {
//
//    public static void main(String[] args) throws IOException {
//
//
//        //创建服务器
//        ServerSocket serverSocket = new ServerSocket(1234);
//
//        //接收客户端连接，阻塞式
//        Socket socket = serverSocket.accept();
//
//        //接收到的socket对象 -> 字节流 -> 字符流
//        InputStream inputStream = socket.getInputStream();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//
//        //控制台打印
//        while (!bufferedReader.readLine().equals("")) {
//            String line = bufferedReader.readLine();
//            System.out.println(line);
//        }
//
//        //关闭字节流
//        bufferedReader.close();
//        inputStream.close();
//
//
//    }
//}
