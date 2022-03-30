package com.papa.baguwen1.baguwen1.easyrpc;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //获取客户端发送的消息，并调用服务
        System.out.println("msg=" + msg );
        //客户端在调用服务器的api 时，我们需要定义一个协议
        //比如我们要求 每次发消息是都必须以某个字符串开头 "HandlerServiceTwo#hello#你好"
        String[] message = msg
                .toString().split("#");
        String serviceName = message[0];
        String methodName = message[1];
        String arg = message[2];
        Object service = ServerBootstrap.serviceMap.get(serviceName);
        Object result = Class.forName(serviceName).getMethod(methodName, String.class)
                .invoke(service, arg);
        ctx.writeAndFlush(result);
    }
}
