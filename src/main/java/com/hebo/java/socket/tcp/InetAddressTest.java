package com.hebo.java.socket.tcp;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author bo.he@ttpai.cn
 */
public class InetAddressTest {


    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("name:" + inetAddress.getHostName());
        System.out.println("ip:" + inetAddress.getHostAddress());
    }
}
