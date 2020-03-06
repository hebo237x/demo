package com.hebo.java.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author bo.he@ttpai.cn
 */
public class UdpSocketClient {

    public static void main(String[] args) throws IOException {
        //1.定义服务器地址
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 10001;
        byte[] data = "用户名：admin".getBytes();
        //2.创建数据报
        DatagramPacket packet = new DatagramPacket(data, data.length, inetAddress, port);
        //3.socket
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);


        //接收服务端响应
        byte[] resultByte = new byte[1024];
        DatagramPacket result = new DatagramPacket(resultByte, resultByte.length);
        socket.receive(result);

        String reply = new String(resultByte, 0, result.getLength());

        System.out.println("服务器返回:" + reply);

        socket.close();
    }
}
