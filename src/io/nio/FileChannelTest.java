package io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class FileChannelTest {
    public static void main(String[] args){
        try {
            RandomAccessFile accessFile = new RandomAccessFile("E:\\dd\\jar\\create.txt", "rw");
            FileChannel inChannel = accessFile.getChannel();
            ByteBuffer bb = ByteBuffer.allocate(1024);
            while(inChannel.read(bb)!=-1){
                bb.flip();
                bb.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
