package com.test.yg.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用telnet进行简单的HTTP请求
 * 步骤如下：
 * <p>
 * 打开cmd,输入： telnet www.baidu.com 80
 * 会跳转进入空白的命令行页面。
 * 输入： Ctrl + ]页面会显示欢迎使用 Microsoft Telnet Client
 * 再按一次回车(Enter)键
 * 进入一个空白页，输入： GET / HTTP/1.0
 * 按两次回车(Enter)键
 * 最后返回一次HTTP完整的请求数据，包括请求头，和主体
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);

        while (true) {
            System.out.println("----- wait connection -----");

            Socket accept = serverSocket.accept();
            System.out.println("----- enter -----");
            new Thread(() -> {
                try {
                    handleClientSocket(accept);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    private static void handleClientSocket(Socket socket) throws IOException {
        while (true) {
            byte[] bytes = new byte[1024];
            System.out.println("ready read data");
            int read = socket.getInputStream().read(bytes);
            System.out.println("read data ok");
            if (read != -1) {
                System.out.println("client send data: " + new String(bytes, 0, read));
            }
        }

    }

}
