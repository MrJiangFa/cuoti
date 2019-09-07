package io;

import java.io.*;
import java.net.URI;
import java.nio.file.*;

public class FileTest {
    public static void main(String[] args) throws IOException {
        testFilesAndPaths();
    }

    private static void testFilesAndPaths() throws IOException {
        Path inputPath = Paths.get("D:/testpath/t1.txt");
        //Path outPath = Paths.get("D:/", "testpath/", "t2.text");
        URI uri = URI.create("file://D:/testpath/t2.text");
        Path outPath = Paths.get(uri);
        if (!Files.exists(inputPath)) {
            Files.createDirectory(Paths.get("D:/testpath"));
            Files.createFile(inputPath);
        }
        //可以直接通过该方式决定以哪种方式打开文件，是否需要新建文件/目录，当然还是必须得在文件所在的目录都存在的情况
        BufferedOutputStream output = new BufferedOutputStream(Files.newOutputStream(inputPath, StandardOpenOption.CREATE, StandardOpenOption.APPEND));
        byte[] writeInBytes = "\t\n you're good again!".getBytes();

        output.write(writeInBytes);
        output.flush();
        output.close();
    }

    public static void testFileInputStream() {
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
