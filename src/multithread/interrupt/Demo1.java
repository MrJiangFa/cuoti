package multithread.interrupt;

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        try {
            int i = 0;
//            while (!isInterrupted()) {
                Thread.sleep(500);
                i++;
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
//            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+" ("+this.getState()+") catch InterruptedException!");
        }
    }
}

public class Demo1 {
    public static void main(String[] args){
        try {
            Thread t1 = new MyThread("t1");
            System.out.println(t1.getName() + " (" + t1.getState() + ") is new");
            t1.start();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is started.");
//            Thread.sleep(300);//主线程休眠300ms，然后主线程给
            t1.interrupt();
            System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted.");
            Thread.sleep(300);
            System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted now.");
            System.out.println(t1.getName() +" " +t1.isAlive());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
