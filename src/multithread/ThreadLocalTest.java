package multithread;

import java.util.Scanner;

public class  ThreadLocalTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int temp0 = 0;
        if (n == s) {
            System.out.println(1);
        } else {
            if (s > n / 2) {
                temp0 = n - s;
            }
            long temp1 = factorial(temp0, n) / factorial(temp0, temp0);
            long temp2 = 2 * (n - s);
            System.out.println((temp1 * temp2)%7);
        }
    }

    private static long factorial(int m, int n) {
        long sum = 1;
        while (m > 0 && n > 0) {
            sum = sum * n--;
            m--;
        }
        return sum;
    }
}
