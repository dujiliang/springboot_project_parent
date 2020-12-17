package com.yunbao.netty.ioclient;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @Author: djl
 * @Date: 2020/7/11 16:54
 * @Version 1.0
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8002);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        socket.getOutputStream().flush();
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }
}
