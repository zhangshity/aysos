package com.zcy.net.UDP_client_server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @ Author: chunyang.zhang
 * @ Description: <>网路通信-客户端-UDP</>
 * @ Date: Created in 15:33 2019-08-16
 * @ Modified: By:
 */
public class Client {

    public static void main(String[] args) throws IOException {

        //建立连接socket
        DatagramSocket datagramSocket = new DatagramSocket(232);

        //UDP报文
        byte[] buf = "UDP报文".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, new InetSocketAddress("localhost", 1235));

        //发送
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
