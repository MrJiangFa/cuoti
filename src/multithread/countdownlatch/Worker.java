package multithread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{
    private CountDownLatch countDownLatch;
    private String name;
    Worker(CountDownLatch countDownLatch,String name){
        this.countDownLatch = countDownLatch;
        this.name = name;
    }
    @Override
    public void run() {
        this.doWork();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name+"活干完了");
        this.countDownLatch.countDown();
    }
    public void doWork(){
        System.out.println(this.name+"正在干活");
    }
}
