package multithread.blockingqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class Java5SynchronousQueue<E> {
    ReentrantLock lock = new ReentrantLock();
    Queue waitingProducers = new LinkedList();
    Queue waitingConsumers = new LinkedList();
    class Node extends AbstractQueuedSynchronizer{
        E item;
        Node next;

    }
}
