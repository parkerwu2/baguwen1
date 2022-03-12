package com.papa.baguwen1.baguwen1.zerocopy;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ZerocopyFile {
    public static void transferToDemo(String from, String to) throws IOException {
        FileChannel fromChannel = new RandomAccessFile(from, "rw").getChannel();
        FileChannel toChannel = new RandomAccessFile(to, "rw").getChannel();
        long position = 0;
        long size = fromChannel.size();
        while (0 < size) {
            long count = fromChannel.transferTo(position, size, toChannel);
            if (count > 0){
                position += count;
                size -= count;
            }
        }
        fromChannel.close();
        toChannel.close();
    }

    public static void transferFromDemo(String from, String to) throws IOException {
        FileChannel fromChannel = new RandomAccessFile(from, "rw").getChannel();
        FileChannel toChannel = new RandomAccessFile(to, "rw").getChannel();
        long position = 0;
        long size = fromChannel.size();
        while (0 < size) {
            long count = toChannel.transferFrom(fromChannel, position, size);
            if (count > 0){
                position += count;
                size -= count;
            }
        }
        fromChannel.close();
        toChannel.close();
    }

    public static void main(String[] args) throws IOException {
        String from = "d:\\work\\data\\1.txt";
        String to = "d:\\work\\data\\2.txt";
        transferToDemo(from, to);
        String to2 = "d:\\work\\data\\3.txt";
        transferFromDemo(from, to2);
    }
}
