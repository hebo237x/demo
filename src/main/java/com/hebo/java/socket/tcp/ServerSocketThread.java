package com.hebo.java.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author bo.he@ttpai.cn
 */
public class ServerSocketThread extends Thread {

    private Socket socket = null;

    public ServerSocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            inputStream = socket.getInputStream();
            isr = new InputStreamReader(inputStream);
            br = new BufferedReader(isr);
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("收到客户端信息:" + info);
            }
            socket.shutdownInput();

            //响应客户端请求
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎登陆");
            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
                if (os != null) {
                    os.close();
                }
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
