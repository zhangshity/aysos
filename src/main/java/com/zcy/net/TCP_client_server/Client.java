package com.zcy.net.TCP_client_server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ Author: chunyang.zhang
 * @ Description: <>网络通信-客户端-TCP</>
 * @ Date: Created in 11:17 2019-08-16
 * @ Modified: By:
 */
public class Client {

    public static void main(String[] args) throws IOException {

        //建立客户端连接socket(指定IP和端口)
        Socket clientSocket = new Socket("localhost", 1333);

        //向服务器发送socket
        OutputStream clientOutputStream = clientSocket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(clientOutputStream);
        dataOutputStream.writeUTF("<Hello，我是阳爹发送的数据，Client 客户端发送的测试连接数据 >");


        dataOutputStream.flush();

        dataOutputStream.close();
        clientOutputStream.close();
    }
}
