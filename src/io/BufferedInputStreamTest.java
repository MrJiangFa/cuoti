package io;

import java.io.*;

public class BufferedInputStreamTest {
    public static void main(String[] args){

        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\dd\\jar\\create.txt"));
            System.out.println((char)bis.read());
            System.out.println((char)bis.read());
            bis.mark(1);
            System.out.println((char)bis.read());
            System.out.println((char)bis.read());
            System.out.println((char)bis.read());
            bis.reset();
            System.out.println((char)bis.read());
            System.out.println((char)bis.read());
            System.out.println((char)bis.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
