package multithread.alterprinting;

public class AlternatePrinting2 {
    private static Object lock = new Object();
    private static volatile int count = 0;

    static class ThreadA extends Thread {
        public void run() {
            for (int i = 0; i < 10; ) {
                synchronized (lock) {
                    if (count % 3 == 0) {
                        System.out.println("A");
                        count++;
                        i++;
                    }
                }
            }
        }
    }
    static class ThreadB extends Thread{
        public void run() {
            for (int i = 0; i < 10; ) {
                synchronized (lock) {
                    if (count % 3 == 1) {
                        System.out.println("B");
                        count++;
                        i++;
                    }
                }
            }
        }
    }
    static class ThreadC extends Thread{
        public void run() {
            for (int i = 0; i < 10; ) {
                synchronized (lock) {
                    if (count % 3 == 2) {
                        System.out.println("C");
                        count++;
                        i++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
