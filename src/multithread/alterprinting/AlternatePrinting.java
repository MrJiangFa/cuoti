package multithread.alterprinting;


/**
 * 三个线程交替打印 ABCABC
 * 同步块，wait,notify控制三个线程的执行次序，控制程序ThreadA->ThreadB->ThreadC按顺序执行
 * 每个线程必须持有两个对象的锁——前一个线程对应的对象锁，自身对象锁
 * 前一个线程对应的对象锁——保证当前线程一定在前一个线程操作之后才开始执行
 * 参考：https://blog.csdn.net/xiaokang123456kao/article/details/77331878
 */
public class AlternatePrinting {
    static class ThreadPrinter extends Thread {
        String name;
        final Object preLock;
        final Object curLock;

        ThreadPrinter(String name, Object preLock, Object curLock) {
            this.name = name;
            this.preLock = preLock;
            this.curLock = curLock;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                synchronized (preLock) {
                    synchronized (curLock) {
                        System.out.println(name);
                        count--;
                        curLock.notifyAll();
                    }//至此执行完curLock的同步块，同时释放curLock锁
                    try {
                        if (count != 0) {
                            preLock.wait();//当前线程进入阻塞状态
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Object a = new Object();
//        Object b = new Object();
//        Object c = new Object();
//        ThreadPrinter pa = new ThreadPrinter("A", c, a);
//        ThreadPrinter pb = new ThreadPrinter("B", a, b);
//        ThreadPrinter pc = new ThreadPrinter("C", b, c);
//        pa.start();
//        Thread.sleep(100);//需要确保线程"pa"先获得锁 c，a
//        pb.start();
//        pc.start();
        alterPrintABC();
    }

    //
    private static void alterPrintABC() throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Object lock3 = new Object();
        new Thread(() -> {
            int count = 1;
            while (count <= 10) {
                synchronized (lock1) {
                    synchronized (lock2) {
                        System.out.println("A");
                        lock2.notify();
                    }
                    try {
                        if (count++ != 10) {
                            lock1.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread.sleep(100);
        new Thread(() -> {
            int count = 1;
            while (count <= 10) {
                synchronized (lock2) {
                    synchronized (lock3) {
                        System.out.println("B");
                        lock3.notify();
                    }
                    try {
                        //等待
                        if (count++ != 10) {
                            lock2.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(() -> {
            int count = 1;
            while (count <= 10) {
                synchronized (lock3) {
                    synchronized (lock1) {
                        System.out.println("C");
                        lock1.notify();
                    }
                    try {
                        if (count++ != 10) {
                            lock3.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}



