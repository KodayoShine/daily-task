package com.test.yg.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NioSelectorServer {

    static List<SocketChannel> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9000));
        // 设置成为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 创建多路复用 epoll
        Selector selector = Selector.open();
        // 将serverSocketChannel注册到selector上,并对accept连接进行关注
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            // 阻塞,等待op_accept的事件
            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            // 循环全部的SelectionKey的事件
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 处理连接获取事件
                // 对于内部再次注册read的事件
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = server.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    // 若是read时间,进行读取和打印操作
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
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

}
