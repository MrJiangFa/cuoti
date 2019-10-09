package multithread.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingQueueReconstruct<E> {
    LinkedBlockingQueue queue = new LinkedBlockingQueue();

    static class Node<E> {
        E item;
        Node<E> next;

        Node(E x) {
            item = x;
        }
    }

    private final int capacity;
    private final AtomicInteger count = new AtomicInteger();
    transient Node<E> head;
    private transient Node<E> last;
    private final ReentrantLock takeLock = new ReentrantLock();
    private final Condition notEmpty = takeLock.newCondition();
    private final ReentrantLock putLock = new ReentrantLock();
    private final Condition notFull = putLock.newCondition();

    //唤醒拿操作——唤醒 notEmpty 等待队列上等待去队列中拿元素的线程
    private void signalNotEmpty() {
        final ReentrantLock lock = this.takeLock;
        lock.lock();
        try {
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    private void signalNotFull() {
        final ReentrantLock lock = this.putLock;
        lock.lock();
        try {
            notFull.signal();
        } finally {
            lock.unlock();
        }
    }
    private void enqueue(Node<E> node){
        last = last.next = node;
    }
    //dequeue 将链表head删除，让其下一个节点作为新的头
    private void dequeue(){
        Node<E> h = head;
        Node<E> first = h.next;


    }

}
