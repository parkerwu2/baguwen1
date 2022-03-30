package com.papa.baguwen1.baguwen1.easyrpc.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {
    private ChannelHandlerContext context;//上下文
    private String result;//返回结果
    private String para; //客户端调用方法时的入参

    //与服务器的连接创建后，就会被调用, 这个方法是第一个被调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接到服务器");
        context = ctx;
    }

    //收到服务器的数据后，调用方法 (4)
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端收到服务端返回" + msg);
        result = msg.toString();
        synchronized (this) {
            notify();//唤醒等待的线程
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("发生异常" + cause);
        ctx.close();
    }

    //被代理对象调用, 发送数据给服务器，-> wait -> 等待被唤醒(channelRead) -> 返回结果 (3)-》5
    @Override
    public Object call() throws Exception {
        context.writeAndFlush(para);
        //进行wait 等待channelRead 方法获取到服务器的结果后，唤醒
        synchronized(this) {
            wait();
        }
        //服务方返回的结果
        return  result;
    }
    void setPara(String para) {
        this.para = para;
    }

}
