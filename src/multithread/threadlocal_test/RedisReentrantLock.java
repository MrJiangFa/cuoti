package multithread.threadlocal_test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 通过 ThreadLocal 及 redis 的 Jedis 接口，设计可重入锁
 */

public class RedisReentrantLock {
    public static void main(String[] args) {
        System.out.println(foo(4,2018));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.sort(Comparator.comparingInt(n -> n));
    }
    static int foo(int a, int b) {
        if (a >= b) {
            if (a == b)  return a;  else  return 0;
        } else {
            return foo(a + 1, b - 1) + a + b;
        }
    }


}
