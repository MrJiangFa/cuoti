package multithread;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.HashMap;

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        ReaderThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("此时" + 2);
//            while(!ready){
//                try {
//                    Thread.sleep(1000);//运行状态->转为就绪状态，其他具有相同优先级的线程获得执行权
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            System.out.println(Thread.currentThread().getName() + "-->" + number);
        }
    }

    public static void main(String[] args) {
        //主线程启动
        ready = true;
        number = 11;
        number = 20;
        System.out.println(Thread.currentThread().getName());
        ReaderThread t1 = new ReaderThread("t1");
        t1.start();//启动read线程
//            t1.interrupt();
        try {
            t1.join();//主线程等子线程完成之后才能运行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());//此处执行的还是main线程
        //ready类加载，初始化之前，其值为false,read线程进入就绪状态，开始执行main线程，main线程执行完之后
        number = 10;
    }
}
