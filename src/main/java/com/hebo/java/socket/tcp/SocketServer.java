package com.hebo.java.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author bo.he@ttpai.cn 基于TCP协议实现socket
 */
public class SocketServer {

    public static void main(String[] args) {
        try {
            //创建server socket
            ServerSocket serverSocket = new ServerSocket(10001);
            System.out.println("服务端启动,等待客户端连接");
            Socket socket = null;
            int count = 0;
            while (true) {
                socket = serverSocket.accept();
                ServerSocketThread serverSocketThread = new ServerSocketThread(socket);
                serverSocketThread.start();

                count++;
                System.out.println("客户端数量:" + count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
