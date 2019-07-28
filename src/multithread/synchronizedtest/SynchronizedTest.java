package multithread.synchronizedtest;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class SynchronizedTest {
    static class MyThread extends Thread {
        boolean exit = false;

        @Override
        public void run() {
            while (Thread.interrupted()) {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(i);
                    if (i == 9) {
                        exit = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer a = 10;
        synchronized (a) {
            a += 1;
        }
        new Thread(){
            public void run(){

            }
        }.run();
    }

    public synchronized void print(int s) {
        notify();
        System.out.println(s);
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
