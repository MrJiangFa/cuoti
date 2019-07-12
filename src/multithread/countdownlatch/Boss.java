package multithread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Boss implements Runnable{
    private CountDownLatch countDownLatch;
    Boss (CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run(){
        System.out.println("老板正在等所有工人干完活");
        try {
            this.countDownLatch.await();//
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("工人都干完活，老板开始检查");
    }
}
