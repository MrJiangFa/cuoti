package design_parttern;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式：属于行为模式
 * 应用：当一个对象被修改时，所有的依赖对象（观察者对象）都会得到通知
 * 优点：1.观察者和被观察者是抽象耦合的；2.建立一套触发机制
 * 缺点：1.如果观察者和被观察者众多，通过所有的观察者将会花费大量时间；2.观察者和观察目标之间有循环依赖的话，可能导致系统崩溃；
 * 3.观察者
 * <p>
 * 应用场景：一个对象必须通知其他对象，而不知道其他对象是谁
 * <p>
 * 如果顺序执行，某一观察者错误会导致系统卡壳，一般采用异步方式；
 * <p>
 * 构成：Subject类，Observer类，Client类
 * Subject对象带有绑定观察者到Client对象和从Client对象解绑观察者的方法
 */
public class ObserverPattern {
    static class Subject {
        private List<Observer> observers = new ArrayList<>();
        private int state;

        public int getState() {
            return state;
        }

        //为属性改变设置统一set方法，只要进入set方法，就会唤醒对应的观察者
        public void setState(int state) {
            this.state = state;
            notifyAllServers();
        }

        public void attach(Observer observer) {
            observers.add(observer);
        }

        public void notifyAllServers() {
            for (Observer observer : observers) {
                observer.update();
            }
        }
    }

    static abstract class Observer {
        protected Subject subject;

        public abstract void update();
    }

    static class BinaryObserver extends Observer {
        public BinaryObserver(Subject subject) {
            this.subject = subject;
            this.subject.attach(this);
        }

        @Override
        public void update() {
            System.out.println("Binary String:" + Integer.toBinaryString(subject.getState()));
        }
    }

    static class OctalObserver extends Observer {
        public OctalObserver(Subject subject) {
            this.subject = subject;
            this.subject.attach(this);
        }

        @Override
        public void update() {
            System.out.println("Octal String:" + Integer.toOctalString(subject.getState()));
        }
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        System.out.println("fist state change 15");
        subject.setState(15);
        System.out.println("second state change 10");
        subject.setState(10);
    }
}
