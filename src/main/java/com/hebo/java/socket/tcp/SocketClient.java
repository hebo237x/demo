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
public class SocketClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 10001);

            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名：admin");
            pw.flush();

            socket.shutdownOutput();


            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("收到服务端信息:" + info);
            }

            br.close();
            is.close();

            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
