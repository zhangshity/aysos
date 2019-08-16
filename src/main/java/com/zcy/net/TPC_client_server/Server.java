package com.zcy.net.TPC_client_server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ Author: chunyang.zhang
 * @ Description: <>网络通信-服务器-TCP</>
 * @ Date: Created in 11:04 2019-08-16
 * @ Modified: By:
 */
public class Server {

    public static void main(String[] args) throws IOException {

        //创建服务器连接socket
        ServerSocket serverSocket = new ServerSocket(1333);

        int reciveCounter = 0;//接收socket计数器
        while (true) { //循环接收
            //接收客户端socket
            Socket clientSocket = serverSocket.accept();
            System.out.printf("%d 新连接... %s:%d Client Connect successfully! >>> %n", ++reciveCounter, clientSocket.getInetAddress(), clientSocket.getPort());
            //客户端socket转换为InputStream,并读取输出
            InputStream clientInputStream = clientSocket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(clientInputStream);
            String acceptResult = dataInputStream.readUTF();
            System.out.printf("第%d数据: %s %n", reciveCounter, acceptResult);


            dataInputStream.close();
            clientSocket.close();
        }
    }
}
