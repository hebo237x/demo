package com.hebo.java.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author bo.he@ttpai.cn
 */
public class UdpSocketServer {

    public static void main(String[] args) throws IOException {
        //1.创建服务端udp socket
        DatagramSocket socket = new DatagramSocket(10001);
        //2.创建数据报 接收客户端信息
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        //3.接收客户端发送的数据 接收数据报之前 阻塞
        socket.receive(packet);
        //4.读取客户端信息
        String info = new String(data, 0, packet.getLength());
        System.out.println("接收到客户端信息：" + info);


        //响应客户端

        //获取客户端地址
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] response = "登录成功".getBytes();

        DatagramPacket responsePacket = new DatagramPacket(response, response.length, address, port);
        socket.send(responsePacket);


        socket.close();
    }
}
