package com.papa.baguwen1.baguwen1.easyrpc;

import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.HashMap;
import java.util.Map;

public class ServerBootstrap {
    public static Map<String,Object> serviceMap = new HashMap();
    public static void main(String[] args) {
        //两个接口的全类名
        String handlerServiceTwo = HandlerServiceTwo.class.getName();
        String handlerServiceOne = HandlerServiceOne.class.getName();
        //注册服务
        serviceMap.put(handlerServiceTwo,new HandlerServiceTwoImpl());
        serviceMap.put(handlerServiceOne,new HandlerServiceOneImpl());

        startServer("127.0.0.1", 7000);
    }

    private static void startServer(String hostname, int port) {
        EventLoopGroup boosGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            io.netty.bootstrap.ServerBootstrap serverBootstrap = new io.netty.bootstrap.ServerBootstrap();
            serverBootstrap.group(boosGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(new NettyServerHandler());
                        }
                    });
            ChannelFuture channelFuture = serverBootstrap.bind(hostname, port).sync();
            System.out.println("服务提供方开始提供服务~~");
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e){
            System.out.println(e.getCause());
        } finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
