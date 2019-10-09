package multithread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(16);
        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);
        Consumer c1 = new Consumer(queue);
        new Thread(p).start();
        new Thread(c).start();
        new Thread(c1).start();
    }

    static class Producer implements Runnable {
        private final BlockingQueue queue;

        Producer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    queue.put(produce());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private static String produce() {
            String res = "产品";
            System.out.println("prducer....开始生产");
            return res;
        }
    }

    static class Consumer implements Runnable {
        private final BlockingQueue queue;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    consume(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void consume(Object x) {
            System.out.println(Thread.currentThread().getId()+"consumer...开始消费");
        }
    }
}
