package com.zcy.net.UDP_client_server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @ Author: chunyang.zhang
 * @ Description: <>网络通信-服务器-UDP传输</>
 * @ Date: Created in 15:28 2019-08-16
 * @ Modified: By:
 */
public class Server {

    public static void main(String[] args) throws IOException {

        //建立连接,指定端口
        DatagramSocket datagramSocket = new DatagramSocket(1235);

        //指定数组和DatagramPacket对象容器存放接收的数据
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);

        while (true) {
            datagramSocket.receive(datagramPacket);
            System.out.println(new String(buf, 0, datagramPacket.getLength()));
        }

    }
}
