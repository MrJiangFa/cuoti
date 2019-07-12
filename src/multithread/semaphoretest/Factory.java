package multithread.semaphoretest;

import java.util.concurrent.Semaphore;

public class Factory {
    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(5);

        int numOfWorkers = 8;
        for(int i = 0;i<numOfWorkers;i++){
            Worker2 w = new Worker2(i,semaphore);
            w.start();
        }
    }
}
