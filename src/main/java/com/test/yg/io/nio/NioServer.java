package com.test.yg.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NioServer {

    static List<SocketChannel> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9000));
        // 设置成为非阻塞
        serverSocketChannel.configureBlocking(false);

        while (true) {
            SocketChannel accept = serverSocketChannel.accept();
            if (accept != null) {
                // 客户端也设置成为非阻塞
                accept.configureBlocking(false);
                list.add(accept);
            }

            Iterator<SocketChannel> iterator = list.iterator();
            while (iterator.hasNext()) {
                SocketChannel socketChannel = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                int read = socketChannel.read(byteBuffer);
                if (read > 0) {
                    System.out.println("--- 当前数据:" + new String(byteBuffer.array()));
                } else {
                    iterator.remove();
                    System.out.println("客户端断开连接");
                }
            }
        }

    }

}
