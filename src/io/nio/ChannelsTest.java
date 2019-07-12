package io.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelsTest {
    public static void main(String[] args) {
        try {
            RandomAccessFile accessFile = new RandomAccessFile("E:\\dd\\jar\\create.txt", "rw");
            FileChannel inChannel = accessFile.getChannel();
            ByteBuffer head = ByteBuffer.allocate(6);
            ByteBuffer body = ByteBuffer.allocate(4);
            ByteBuffer[] headAndBody = {head, body};
            inChannel.read(headAndBody);
            for(ByteBuffer buf : headAndBody){
                buf.flip();
                while(buf.hasRemaining()){
                    System.out.println((char)buf.get());
                }
                buf.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
