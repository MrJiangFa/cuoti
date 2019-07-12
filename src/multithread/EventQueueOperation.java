package multithread;

import java.util.LinkedList;

public class EventQueueOperation {
    public static void main(String[] args) {
        EventQueue eq = new EventQueue(new LinkedList<Integer>());
        Producer p = new Producer(eq);
        Consumer c = new Consumer(eq);
        p.produce(5);
        c.consume();
        c.consume();
    }
}

class Producer {
    private EventQueue eq;

    Producer(EventQueue eq) {
        this.eq = eq;
    }

    public void produce(int nums) {
        new Thread() {
            public void run() {
                eq.add(nums);
            }
        }.start();
    }
}

class Consumer {
    private EventQueue eq;

    Consumer(EventQueue eq) {
        this.eq = eq;
    }

    public void consume() {
        new Thread() {
            public void run() {
                eq.consume();
            }
        }.start();
    }
}

class EventQueue {
    //队列中元素的实际数量，以LinkedList实现队列，没有容量的限制
    private LinkedList<Integer> queue;

    public EventQueue(LinkedList queue) {
        this.queue = queue;
    }

    //向整数队列中添加一个数值
    public synchronized void add(int val) {
        while (val > 0) {
            for (int i = 0; i < val; i++) {
                queue.offer(i);
            }
            System.out.printf("%s add(%d)\n", Thread.currentThread().getName(), val);
            try {
                wait();
            } catch (Exception e) {

            }
            notifyAll();
        }
    }

    public synchronized void consume() {
        try {
            if (queue.size() <= 0) {
                wait();
            }
            System.out.printf("%s consume(%d)\n", Thread.currentThread().getName(), queue.pop());
            notifyAll();
        } catch (InterruptedException e) {
            System.out.println("数组中没有数据");
            e.printStackTrace();
        }
    }
}
