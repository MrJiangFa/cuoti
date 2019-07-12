package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileTest {
    public static void main(String[] args) {
//        createFile();
        int count = 0;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("E:\\dd\\jar\\create.txt");
            byte[] bytes = new byte[2];
            int tmp;
            while ((tmp = inputStream.read(bytes)) != -1) {
                count = count + tmp;
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createFile() {
        File file = new File("E:\\dd\\jar\\create.txt");
        try {
            file.createNewFile();
            System.out.println(file.mkdirs());
            System.out.println("文件父目录" + file.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
