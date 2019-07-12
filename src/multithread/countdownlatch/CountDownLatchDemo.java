package multithread.countdownlatch;

import java.util.concurrent.*;

public class CountDownLatchDemo {
    public static void main(String[] args){

        SynchronousQueue syc = new SynchronousQueue();
        CyclicBarrier cb = new CyclicBarrier(5);
        ExecutorService service  = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(3);
//      service.execute(new Worker());
        service.submit(new Worker(countDownLatch,"张2"));
        service.submit(new Worker(countDownLatch,"张1"));
        service.submit(new Worker(countDownLatch,"张3"));
        service.submit(new Boss(countDownLatch));
        service.shutdown();
    }
}
