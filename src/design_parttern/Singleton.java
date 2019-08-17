package design_parttern;

public class Singleton {
    public static void main(String[] args) {

    }
    /**
     * 懒汉式：用的时候再创建，线程不安全
     */
    static class LazySingleton {
        private static LazySingleton instance = null;//设置为null是为了延迟加载
        private LazySingleton() {
        }
        public static LazySingleton getInstance() {
            if (instance == null) {
                instance = new LazySingleton();
            }
            return instance;
        }
    }


    /**
     * 采用synchronized关键字来保证线程安全性，排他锁影响效率；
     */
    static class ThreadSaveLazySingleton {
        private static ThreadSaveLazySingleton instance = null;
        private ThreadSaveLazySingleton() {
        }
        public synchronized static ThreadSaveLazySingleton getInstance() {
            if (instance == null) {
                instance = new ThreadSaveLazySingleton();
            }
            return instance;
        }
    }

    /**
     * 饿汉式：线程安全，但是并非懒汉式加载
     */
    static class HungrySingleton {
        private static HungrySingleton instance = new HungrySingleton();
        private HungrySingleton() {
        }
        public static HungrySingleton getInstance() {
            return instance;
        }
    }

    /**
     * 双检测，双重校验锁（double check locking,DCL)
     * 懒汉式初始化，线程安全
     */
    static class DCLSingleton {
        private volatile static DCLSingleton instance = null;
        private DCLSingleton() {
        }
        public static DCLSingleton getInstance() {
            if (instance == null) {
                synchronized (DCLSingleton.class) {
                    instance = new DCLSingleton();
                }
            }
            return instance;
        }
    }

    /**
     * 登记式，静态内部类
     * 线程安全，通过静态内部类的方式实现延迟加载，同时又保证了安全性，相比于第三种方法要好
     */
    static class StaticInnerClassSingleton{
        private static class SingletonHolder{
            private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
        }
        private StaticInnerClassSingleton(){}
        public static StaticInnerClassSingleton getInstance(){
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 通过枚举的方式，不仅能避免多线程安全问题，可以防止反序列化构造新对象
     */
    static enum EnumSingleto{
        ISNSTANCE;
        public void whateverMethod(){}
    }
}
