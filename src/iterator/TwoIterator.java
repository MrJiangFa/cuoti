package iterator;

import java.util.concurrent.*;

/**
 * 两种迭代器：Enumeration / Iterator
 * <p>
 * Enumeration的常见实现类：Vector(Stack,Enumeration<E> elements())，Dictionary(HashTable实现了该抽象类)
 *
 * hasMoreElements();nextElement();
 *
 * Iterator接口：hasNext();next();remove()
 *
 * 二者的区别在于Iterator接口中提供了删除元素的能力
 */
public class TwoIterator {
    CountDownLatch latch = new CountDownLatch(10);

    public static void main(String[] args) {
        Executors.newFixedThreadPool(20);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 20, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));
    }
}
