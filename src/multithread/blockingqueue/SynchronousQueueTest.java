package multithread.blockingqueue;

public class SynchronousQueueTest<E> {
    //采用wait()配合notify()、notifyAll()的方式控制对于一个变量的访问，从而实现SynchronousQueue

    boolean putting = false;
    volatile E item = null;

    public synchronized E take() throws InterruptedException {
        while (item == null)
            wait();
        E e = item;
        item = null;
        notifyAll();
        return e;
    }

    public synchronized void put(E e) throws InterruptedException {
        if (e == null)
            return;
        while (putting)
            wait();
        putting = true;
        item = e;
        notifyAll();
        while (item != null)
            wait();
        putting = false;
        notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueueTest<String> queue = new SynchronousQueueTest<String>();
        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread start");
                try {
                    queue.put("1");
                } catch (InterruptedException e) {
                }
                System.out.println("put thread end");
            }
        });

        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread start");
                try {
                    System.out.println("take from putThread: " + queue.take());
                } catch (InterruptedException e) {
                }
                System.out.println("take thread end");
            }
        });

        putThread.start();
        Thread.sleep(1000);
        takeThread.start();
    }

}
