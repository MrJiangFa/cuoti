package multithread.blockingqueue;

import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 对 ArrayBlockingQueue 进行重构——分析具体实现
 *
 * @param <E>
 */
public class ArrayBlockingQueueReconstruct<E> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable {
    public static void main(String[] args) {
    }

    private Object[] items;
    private int takeIndex;//take,poll,remove,peek 这些方法即将取的下一个元素
    private int putIndex;//put,add,offer
    private int count;
    private final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    /**
     * @param capacity
     * @param fair：fair=true 表示被阻塞的put，take操作的线程以FIFO顺序进行相关操作；否则不以FIFO顺序进行操作；
     */
    public ArrayBlockingQueueReconstruct(int capacity, boolean fair) {
        if (capacity <= 0)
            throw new IllegalArgumentException();
        this.items = new Object[capacity];
        lock = new ReentrantLock(fair);
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    public ArrayBlockingQueueReconstruct(int capacity) {
        this(capacity, false);
    }

    public ArrayBlockingQueueReconstruct(int capacity, boolean fair, Collection<? extends E> collection) {
        this(capacity, fair);
        ReentrantLock lock = this.lock;
        try {
            lock.lock();
            int i = 0;
            try {
                for (E e : collection) {
                    if (e == null)
                        throw new NullPointerException();
                    items[i++] = e;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IllegalArgumentException();
            }
            count = i;
            putIndex = count == capacity ? 0 : i;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 只有获取了 lock 之后才能进行enqueue操作；
     *
     * @param e
     */
    private void enqueue(E e) {
        final Object[] items = this.items;
        items[putIndex] = e;
        if (++putIndex == items.length) {
            putIndex = 0;
        }
        count++;
        notEmpty.signal();
    }

    private E dequeue() {
        Object[] items = this.items;
        E x = (E) items[takeIndex];
        items[takeIndex] = null;
        if (++takeIndex == items.length)
            takeIndex = 0;
        count--;
        notFull.signal();
        return x;
    }

    void remveAt(final int removeIndex) {
        Object[] items = this.items;
        if (removeIndex == takeIndex) {
            items[removeIndex] = null;
            if (++takeIndex == items.length)
                takeIndex = 0;
            count--;
        } else {
            final int putIndex = this.putIndex;
            for (int i = removeIndex; ; ) {
                int next = i + 1;
                if (next == items.length)
                    next = 0;
                if (next != putIndex) {
                    items[i] = items[next];
                    i = next;
                } else {
                    items[i] = null;
                    this.putIndex = i;
                    break;
                }
            }
            count--;
        }
        notFull.signal();
    }

    public void checkNotNull(Object e) {
        if (e == null)
            throw new NullPointerException();
    }


    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void put(E e) throws InterruptedException {
        checkNotNull(e);
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == items.length) {
                notFull.await();//队列已经满时，
            }
            enqueue(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        checkNotNull(e);
        long nanos = unit.toNanos(timeout);
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == items.length) {
                if (nanos <= 0)
                    return false;
                nanos = notFull.awaitNanos(nanos);
            }
            enqueue(e);
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E take() throws InterruptedException {
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            return dequeue();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        return 0;
    }

    @Override
    public boolean offer(E e) {
        checkNotNull(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (count == items.length)
                return false;
            else
                enqueue(e);
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
