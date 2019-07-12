package multithread.alterprinting;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AlternatePrinting3 {
    private static volatile AtomicInteger count = new AtomicInteger(0);

    static class MyThread3 extends Thread {
        ReentrantLock lock;
        Condition A;
        Condition B;
        Condition C;

        public MyThread3(String name, ReentrantLock lock, Condition A, Condition B, Condition C) {
            super(name);
            this.lock = lock;
            this.A = A;
            this.B = B;
            this.C = C;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                switch (Thread.currentThread().getName()) {
                    case "A":
                        for (int i = 0; i <= 33; i++) {
                            while (count.intValue() % 3 != 0)
                                A.await();
                            System.out.println(Thread.currentThread().getName() + " " + count);
                            count.incrementAndGet();
                            B.signal();
                        }
                        break;
                    case "B":
                        for (int i = 0; i <= 33; i++) {
                            while (count.intValue() % 3 != 1)
                                B.await();
                            System.out.println(Thread.currentThread().getName() + " " + count);
                            count.incrementAndGet();
                            C.signal();
                        }
                        break;
                    case "C":
                        for (int i = 0; i < 33; i++) {
                            while (count.intValue() % 3 != 2)
                                C.await();
                            System.out.println(Thread.currentThread().getName() + " " + count);
                            count.incrementAndGet();
                            A.signal();
                        }
                        break;
                    default:
                        break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition A = lock.newCondition();
        Condition B = lock.newCondition();
        Condition C = lock.newCondition();
        new MyThread3("A", lock, A, B, C).start();
        new MyThread3("B", lock, A, B, C).start();
        new MyThread3("C", lock, A, B, C).start();
    }
}
