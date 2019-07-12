package io;


import java.io.*;

public class ReaderTest {
    //
    public static void main(String[] args) throws IOException {
//        String str = null;
//        try {
//            //蒋发
//            BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream("E:\\dd\\jar\\create.txt")), "GBK"));
//            BufferedReader br2 = new BufferedReader(new FileReader("E:\\dd\\jar\\create.txt"));
//            System.out.println(br2.readLine());
//            System.out.println("将");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        deleteAndCopy("E:\\dd\\jar\\create.txt","E:\\dd\\jar\\create2.txt");
//        write1("E:\\dd\\jar\\create2.txt");
    }

    public static void deleteAndCopy(String inPath, String outPath) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            String tmp = null;
            reader = new BufferedReader(new FileReader(inPath));
            writer = new BufferedWriter(new FileWriter(outPath));
            while ((tmp = reader.readLine()) != null) {
                String w = tmp.replace('a', '*');
                writer.write(w+"\r\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
            }
        }
    }

    public static void write1(String path) throws IOException {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path));
            bw.write("adjadgkjlds");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bw.close();
        }

    }
}
