package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SocketChannelTest {
    public static void main(String[] args){
        try {
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("https://www.baidu.com/",80));
            ByteBuffer buf = ByteBuffer.allocate(48);
            socketChannel.read(buf);
            String newData = "New string to write to file..."+System.currentTimeMillis();
            ByteBuffer wrBuf = ByteBuffer.allocate(100);
            socketChannel.write(wrBuf.put(newData.getBytes()));
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
