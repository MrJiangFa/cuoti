package io.nio;

import sun.misc.Signal;

import java.util.concurrent.TimeUnit;

public class GracefulOut {
    //优雅推出的方式之一：JVM睡了7秒，然后执行线程；

    /**
     * 存在的问题：
     * 1.遭遇到JVM崩溃等情形，无法执行ShutdownHook
     * 2.存在多个ShutdownHook时，JVM无法保证执行先后顺序
     * 3.
     *
     * @throws InterruptedException
     */
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

    private static void gracefulOut2() {
        //判别是Windows系统还是Linux系统，分别对应不同的退出指令；
        String command = System.getProperties().getProperty("os.name").toLowerCase().startsWith("win") ? "INT" : "TERM";
        System.out.println(command);
        Signal signal = new Signal("INT");
        Signal.handle(signal, (s) -> {
            System.out.println("signal handle start...");
            try {
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            System.out.println("shutdownhook execute start...");
            System.out.println("Neety NioEventLoopGroup shutdownGracefully...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("shutdownhook execute end..");
        }, ""));

    }

    public static void main(String[] args) throws InterruptedException {
        gracefulOut2();
    }
}
