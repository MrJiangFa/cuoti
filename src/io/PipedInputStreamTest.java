package io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class Receiver extends Thread {
    PipedInputStream in = new PipedInputStream();

    @Override
    public void run() {
        readMessageOnce();
//        readMessageContinued();
    }

    //从管道输入流中读取1次数据
    public void readMessageOnce() {
        byte[] buf = new byte[2048];//虽然buf大小为2048个字节，但是最多只会冲“管道输入流”中读取1024个字节
        try {
            int len = in.read(buf);
            System.out.println(new String(buf, 0, len));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //从管道输入流中读取1024个字节,就停止读取
    public void readMessageContinued() {
        int total = 0;
        while (true) {
            byte[] buf = new byte[1024];
            try {
                int len = in.read(buf);
                total += len;
                System.out.println(new String(buf, 0, len));
                if (total > 1024) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class Sender extends Thread {
    PipedOutputStream out = new PipedOutputStream();

    public void run() {
//        writeShortMessage();
        writeLongMessage();
    }

    //向管道输出流中写入一则较短的消息
    public void writeShortMessage() {
        String str = "this is a short message";
        try {
            out.write(str.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLongMessage() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 102; i++) {
            sb.append("fajdsl;kfa");
        }
        //再写入26个字节
        sb.append("abcdefghijklmnopqrstuvwxyz");
        //str的总长度为1024+26 = 1046个字节
        String str = sb.toString();
        try {
            out.write(str.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class PipedInputStreamTest {
    public static void main(String[] args) {
        Sender sender = new Sender();
        Receiver receiver = new Receiver();
        PipedOutputStream out = sender.out;
        PipedInputStream in = receiver.in;
        try {
            in.connect(out);
            sender.start();
            receiver.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
