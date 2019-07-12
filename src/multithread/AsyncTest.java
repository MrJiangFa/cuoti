package multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class AsyncTest {
    private String p;

    public AsyncTest(String p) {
        this.p = p;
        BlockingQueue queue = new ArrayBlockingQueue(3);
        BlockingQueue queue2 = new LinkedBlockingDeque(3);

    }
}
