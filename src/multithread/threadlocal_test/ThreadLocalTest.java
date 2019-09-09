package multithread.threadlocal_test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalTest {
    private static final int IPHONE = 1;
    private static final int IPAD = 2;
    private static final List<Integer> list = new ArrayList<>();
    private static final AtomicInteger nextId = new AtomicInteger(0);
    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };


    private static int getId() {
        return nextId.get();
    }

    public static void luckyTurntable() {
        int[] arr = new int[100];
        arr[0] = IPHONE;
        arr[3] = IPAD;
        arr[5] = IPHONE;
        arr[7] = IPAD;
        for (int i = 0; i < 3; i++) {
            int randomIndex = new Random(System.currentTimeMillis()).nextInt(arr.length);
            if (arr[randomIndex] == IPHONE) {
                synchronized (arr) {
                    if (arr[randomIndex] == IPHONE) {
                        arr[randomIndex] = 0;
                    }
                }
                list.add(IPHONE);
            } else if (arr[randomIndex] == IPAD) {
                synchronized (arr) {
                    if (arr[randomIndex] == IPAD) {
                        arr[randomIndex] = 0;
                    }
                }
                list.add(IPAD);
            }
        }
        list.forEach((i) -> System.out.println("获得索引为奖品为" + (i == IPHONE ? "iphone" : "ipad")));
        Arrays.stream(arr).forEach(System.out::println);
    }




    private static void testThreadLocal() {
        ThreadLocal<String> localName = new ThreadLocal<>();
        ThreadLocal<String> localName2 = new ThreadLocal<>();
        localName.set("jj");
        localName2.set("fafa");
        System.out.println(localName2.get());
    }

    public static void main(String[] args) {
        testThreadLocal();
    }
}
