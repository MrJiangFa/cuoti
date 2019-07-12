package multithread.semaphoretest;

import java.util.concurrent.Semaphore;

public class Worker2 extends Thread{

    int id;
    private Semaphore semaphore;
    Worker2(int id,Semaphore semaphore){
        this.id = id;
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            semaphore.acquire();
            System.out.println("工人"+this.id+"占用一台机器");
            Thread.sleep(2000);
            System.out.println("工人"+this.id+"释放出机器");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
