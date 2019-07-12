package tree;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class BigIntegerTest {
    public static void main(String[] args){
        String a = "32";
        int num1 = a.charAt(1);
        int num2 = a.charAt(0);
        int num3 = '0';
        int num4 = 'a';
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
        ReentrantLock lock = new ReentrantLock(false);
        lock.lock();
    }
    private static String multiply(String numa,String numb){
        String num1 = new StringBuilder(numa).reverse().toString();
        System.out.println(num1);
        String num2 = new StringBuilder(numb).reverse().toString();
        // even 99 * 99 is < 10000, so maximaly 4 digits
        int[] d = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i);
            System.out.println(a);
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                d[i + j] += a * b;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d.length; i++) {
            int digit = d[i] % 10;
            int carry = d[i] / 10;
            sb.insert(0, digit);
            if (i < d.length - 1)
                d[i + 1] += carry;
        }
        //trim starting zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
