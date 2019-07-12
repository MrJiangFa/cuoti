package io;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayInputStreamTest {
    private static final int LEN = 5;
    private static final byte[] ARRAY_LETTERS = {0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
            0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A};

    public static void main(String[] args) {
        String tmp = new String(ARRAY_LETTERS);
        String tmp2 = new String();
        System.out.println("ARRAY_LETTERS=" + tmp);
        ByteArrayInputStream bais = new ByteArrayInputStream(ARRAY_LETTERS);
        for (int i = 0; i < 5; i++) {
            if(bais.available()>=0){
                int t = bais.read();
                System.out.printf("%d : 0x%s\n",i,Integer.toHexString(t));
            }
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bs = new byte[]{97,98,99};
        bos.write(bs,0,bs.length);
        System.out.println(Arrays.toString(bos.toByteArray()));
        System.out.println(bos.toString());
        bos.write(65);
        System.out.println(bos.toString());
        ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
        try {
            bos.writeTo(bos2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("bos2:"+bos2.toString());
    }
}
