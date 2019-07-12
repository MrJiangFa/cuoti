package io;

import java.io.*;

public class CopyTest {
    //文件内容copy
    public static void main(String[] args) {
        byte[] buffer = new byte[30];//定义30个字节的缓冲区
        int numOfRead;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("E:\\dd\\jar\\create.txt"));
            bos = new BufferedOutputStream(new FileOutputStream("E:\\dd\\jar\\create2.txt"));
            while ((numOfRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, numOfRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                bos.close();

            } catch (IOException e) {
            }
        }
    }

    static class Student {
        String name;
        int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    //对象copy，序列化和反序列化
    public static void copyObject() {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(""));
            ois = new ObjectInputStream(new FileInputStream(""));
        } catch (IOException e) {

        }
    }
}
