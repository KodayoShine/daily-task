package com.test.yg.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    // 全局channel的集合
    private static final ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    /**
     * 当channel一旦连通的情况下, 就会调用当前方法
     * 就会将客户端连接保存到channelGroup
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + "上线了 " + simpleDateFormat.format(new Date()) + " \n");
        channelGroup.add(channel);

        System.out.println(channel.remoteAddress() + "上线了 \n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + "下线了 " + simpleDateFormat.format(new Date()) + " \n");
        System.out.println(channel.remoteAddress() + "下线了 \n");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
        // 获取当前channel
        Channel channel = channelHandlerContext.channel();

        // 遍历channelGroup ,根据不同的情况,回送不同的消息
        channelGroup.forEach(ch -> {
            // 当前消息不是自己所发送的
            if (channel != ch) {
                ch.writeAndFlush("[客户端]" + channel.remoteAddress() + " 发送了消息: " + msg + "\n");
            } else {
                ch.writeAndFlush("[自己] 发送了消息: " + msg + "\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
