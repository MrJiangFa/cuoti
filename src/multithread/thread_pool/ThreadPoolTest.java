package multithread.thread_pool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        ThreadPoolExecutor pool2 = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        pool.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("Thread1：" + i);
            }
        });
        pool.submit(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("Thread2：" + i);
            }
        });
    }

    ReentrantLock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Executor executor = Executors.newSingleThreadExecutor();
    ExecutorService service = Executors.newFixedThreadPool(2);
}
