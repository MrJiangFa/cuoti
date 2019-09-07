package multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyTest {
    private Lock lock = new ReentrantLock();
    public static void main(String[] args){
        LockInterruptiblyTest test = new LockInterruptiblyTest();
        Thread thread1 = new Thread(() -> {
            try {
                test.insert(Thread.currentThread());
            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName()+"被中断");
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                test.insert(Thread.currentThread());
            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName()+"被中断");
            }
        });
        thread1.start();
        thread2.start();
        try{
            System.out.println(Thread.currentThread().getName()+"进入睡眠");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally{
            System.out.println(Thread.currentThread().getName()+"睡眠结束");
        }
        thread2.interrupt();
        System.out.println(thread2.isInterrupted());
    }
    private void insert(Thread thread) throws InterruptedException{
        lock.lockInterruptibly();
        try {
            System.out.println(thread.getName()+"得到了锁");
            long startTime = System.currentTimeMillis();
            for(;;){
                if(System.currentTimeMillis()-startTime>=1000){
                    break;
                }
            }
        } finally {
            System.out.println(Thread.currentThread().getName()+"执行finally");
            lock.unlock();
            System.out.println(thread.getName()+"释放了锁");
        }
    }
}
