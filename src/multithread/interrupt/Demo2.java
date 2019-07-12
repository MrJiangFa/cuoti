package multithread.interrupt;

class MyThread2 extends Thread {
    public MyThread2(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

public class Demo2 {
    public static void main(String[] args) {
        Thread t1 = new MyThread2("t1");
        System.out.println(Thread.currentThread().isDaemon());
//        t1.start();
//        for (int i = 0; i < 10000; i++) {
//            System.out.println(Thread.currentThread().getName() + " " + i);
//        }
    }
}
