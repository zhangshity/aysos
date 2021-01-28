package com.zcy.net.TCP_client_server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ Author: chunyang.zhang
 * @ Description: <>TCP网络通信-多线程服务器</>
 * @ Date: Created in 15:35 2019-08-16
 * @ Modified: By:
 */
public class ServerConcurrence {

    public static void main(String[] args) throws IOException {
        //创建服务器连接socket
        ServerSocket serverSocket = new ServerSocket(1333);

        while (true) {
            final Socket clientSocket = serverSocket.accept();
            System.out.printf("新连接... %s:%d Client Connect successfully! >>> %n", clientSocket.getInetAddress(), clientSocket.getPort());

            new Thread() { //启动一个新线程
                public void run() {
                    try {
                        //客户端socket转换为InputStream,并读取输出
                        InputStream clientInputStream = clientSocket.getInputStream();
                        DataInputStream dataInputStream = new DataInputStream(clientInputStream);

                        String acceptResult = dataInputStream.readUTF();
                        while (true) {
                            if ((acceptResult = dataInputStream.readUTF()).equals("-1")) {
                                clientInputStream.close();
                            }
                            System.out.printf("数据: %s %n", acceptResult);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
