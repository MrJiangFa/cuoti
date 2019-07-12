package multithread.thread_pool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolTest {
    public static void main(String[] args) {
        final Queue<Runnable> runnables = new ArrayDeque<>();//
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        pool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });

    }
    ReentrantLock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Executor executor = Executors.newSingleThreadExecutor();
    ExecutorService service = Executors.newFixedThreadPool(2);
}
