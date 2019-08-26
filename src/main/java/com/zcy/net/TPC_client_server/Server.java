package com.zcy.net.TPC_client_server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ Author: chunyang.zhang
 * @ Description: <网络通信-服务器-TCP/>
 * @ Date: Created in 11:04 2019-08-16
 * @ Modified: By:
 * <p>
 * <p>=============================================
 * 服务器模拟程序部署:
 * 1.配置JDK (java -version)
 * 2.复制此代码为 Server.java 文件
 * 3.编译文件 (javac -encoding utf-8 Server.class)
 * 4.运行程序 (java Server)
 * 5.等待客户端发送消息并接收打印
 * <p>=============================================
 */
public class Server {

    public static void main(String[] args) throws IOException {

        //创建服务器连接socket
        ServerSocket serverSocket = new ServerSocket(1333);
        System.out.println("Server has started...\n>>> ...\n>>> ...\n>>> ...");

        int reciveCounter = 0;//接收socket计数器

        while (true) { //循环接收
            //接收客户端socket
            Socket clientSocket = serverSocket.accept();
            System.out.printf("%d 新连接... %s:%d Client Connect successfully! >>> %n", ++reciveCounter, clientSocket.getInetAddress(), clientSocket.getPort());
            //客户端socket转换为InputStream,并读取输出
            InputStream clientInputStream = clientSocket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(clientInputStream);
            String acceptResult = dataInputStream.readUTF();

            System.out.printf("第%d条数据: %s %n", reciveCounter, acceptResult);


            dataInputStream.close();
            clientSocket.close();
        }
    }
}
