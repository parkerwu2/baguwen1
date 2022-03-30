package com.papa.baguwen1.baguwen1.easyrpc.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientFactory<T> {
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private Class<T> clazz;
    private static String host = "127.0.0.1";
    private static int port = 7000;

    public ClientFactory(Class<T> clazz){
        this.clazz = clazz;
    }

    /**
     * 使用动态代理模式，获取一个代理对象
     */
    public T getBean() {
        //创建netty客户端 与服务端交互 并让动态代理类持有
        final NettyClientHandler clientHandler = this.getClientHandler();
        return (T)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{clazz}, ((proxy, method, args) -> {
                    //设置要发给服务器端的信息 接口的全类名#方法名#参数
                    clientHandler.setPara(this.initParams(method, args));
                    return executor.submit(clientHandler).get();
                }));
    }

    private String initParams(Method method, Object[] args) {
        return method.getDeclaringClass().getName() + "#" + method.getName() + "#" + args[0];
    }
    /**
     * 初始化客户端
     */
    private NettyClientHandler getClientHandler() {
        NettyClientHandler nettyClientHandler = new NettyClientHandler();
        //创建eventLoopGroup
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new StringDecoder());
                        pipeline.addLast(new StringEncoder());
                        pipeline.addLast(nettyClientHandler);
                    }
                });
        try {
            bootstrap.connect(host, port).sync();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return nettyClientHandler;
    }
}
