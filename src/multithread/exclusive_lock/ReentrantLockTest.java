package multithread.exclusive_lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLock unfairLock = new ReentrantLock();//默认非公平锁
        ReentrantLock fairLock = new ReentrantLock(true);//采用公平方式

    }
}
