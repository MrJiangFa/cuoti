package io;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDescriptorTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FileDescriptor.out);
//        System.out.println("System.out");
        fos.write("FileDescriptor:这里证明了System.out，就是FileDescriptor.out来创建\n".getBytes());
        System.out.println("System.out");
//        FileOutputStream fos1 = new FileOutputStream("E:\\dd\\jar\\create.txt");
//        System.out.println(fos1.getFD());
        fos.close();
//        fos1.close();
        System.out.println("jiang\njaf");
        System.out.println("jiang\rfa");
        System.out.println("jiang\r\nfa");
    }

}
