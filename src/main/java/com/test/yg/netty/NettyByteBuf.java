package com.test.yg.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class NettyByteBuf {

    public static void main(String[] args) {
        // 通过readerIndex和writerIndex和capacity 将buffer分成三个区域
        // 已经读取的区域: [0, readerIndex)
        // 可读取的区域: [readerIndex, writerIndex)
        // 可写的区域: [writerIndex, capacity)
        ByteBuf byteBuf = Unpooled.buffer(10);
        System.out.println(byteBuf);

        for (int i = 0; i < 8; i++) {
            byteBuf.writeByte(i);
        }
        System.out.println(byteBuf);


        for (int i = 0; i < 5; i++) {
            System.out.println(byteBuf.getByte(i));
        }
        System.out.println(byteBuf);

        for (int i = 0; i < 5; i++) {
            System.out.println(byteBuf.readByte());
        }
        System.out.println(byteBuf);


        ByteBuf copiedBuffer = Unpooled.copiedBuffer("hello,netty!", CharsetUtil.UTF_8);
        if (copiedBuffer.hasArray()) {
            byte[] array = copiedBuffer.array();

            System.out.println(new String(array, CharsetUtil.UTF_8));
            System.out.println(copiedBuffer);

            System.out.println(copiedBuffer.readerIndex());
            System.out.println(copiedBuffer.writerIndex());
            System.out.println(copiedBuffer.capacity());


            // 使用for循环读取每一个位置的数值
            // 可读取范围
            int len = copiedBuffer.readableBytes();
            System.out.println("len:" + len);
            for (int i = 0; i < len; i++) {
                System.out.println((char) copiedBuffer.getByte(i));
            }

            // 范围读取
            System.out.println(copiedBuffer.getCharSequence(0, 6, CharsetUtil.UTF_8));
            System.out.println(copiedBuffer.getCharSequence(6, 6, CharsetUtil.UTF_8));

        }


    }
}
