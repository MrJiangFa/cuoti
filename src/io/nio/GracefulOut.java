package io.nio;

import java.util.concurrent.TimeUnit;

public class GracefulOut {
    //优雅推出的方式之一：JVM睡了7秒，然后执行线程；
    private static void gracefulOut1() throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            System.out.println("shutdownhook execute start..");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("shutdownhook execute end..");
        }, ""));
        TimeUnit.SECONDS.sleep(7);
        System.exit(0);
    }

    public static void main(String[] args) throws InterruptedException {
        gracefulOut1();
    }
}
