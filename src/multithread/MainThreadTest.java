package multithread;

import java.util.HashMap;

public class MainThreadTest {
    public static void main(String[] args) {
//        try {
//            Thread.sleep(10000);
            Thread t = new Thread() {
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                }
            };
            t.start();
//            Thread.sleep(10);
            for (int i = 0; i < 100000; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
//        } catch (InterruptedException e) {
//            System.out.println(Thread.currentThread().getName() + "catch exception");
//        }
    }
}