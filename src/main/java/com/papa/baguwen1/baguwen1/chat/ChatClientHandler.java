package com.papa.baguwen1.baguwen1.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg){
//        System.out.println(msg.trim());
        System.out.println("服务端: "+msg);
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String result ="result";
        try{
            result = br.readLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("我: " + result);
        ctx.write(result);//给服务端回复
        ctx.flush();
    }
}

