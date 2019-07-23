package design_parttern;

/**
 * 创建型模式：五种——工厂方法模式、抽象工厂模式、单列模式、建造者模式（使用多个简单的对象构建成一个复杂的对象）、原型模式
 * 六大原则：
 * 1. 开闭原则：程序进行拓展时，不能去修改原有代码，需要使用接口和抽象类实现一个热插拔效果
 * 2. 理氏代换原则（LSP）：任何基类可以出现的地方，子类一定可以出现
 * 3. 依赖倒转原则：直接接口编程，依赖于抽象，而不依赖于具体
 * 4. 接口隔离原则：使用多个隔离的接口，比使用单个接口要好
 * 5. 迪米特法则：最少知道原则——一个实体应当尽量少的与其他实体之间发生相互作用
 * 6. 合成复用原则：尽量使用合成/聚合的方式，而不是使用继承
 */
public class FactoryPattern {
    interface Sender {
        void send();
    }

    static class MailSender implements Sender {
        public void send() {
            System.out.println("this is a mailsender");
        }
    }

    static class SmsSender implements Sender {
        public void send() {
            System.out.println("this is a smssender");
        }
    }

    /**
     * 简单工厂方法
     */
    static class SimpleSenderFactory {
        public Sender produce(String type) {
            if ("mail".equals(type)) {
                return new MailSender();
            } else if ("sms".equals(type)) {
                return new SmsSender();
            } else {
                System.out.println("请输入正确的类型");
                return null;
            }
        }
    }

    /**
     * 多个工厂方法模式/静态工厂方法模式 (无需创建工厂对象)
     * 如果传递的字符串出错，则不能创建对象
     */
    static class StaticMethodsSenderFactory {
        public static Sender getMailSender() {
            return new MailSender();
        }

        public static Sender getSmsSender() {
            return new SmsSender();
        }
    }

    /**
     * 直接修改工厂类违反了闭包原则
     * 采用抽象工厂模式创建多个工厂类，一旦增加新功能的时候，增加新的类——需要增加工厂接口
     */
    interface Factory {
        Sender produce();
    }

    static class MailSenderFactory implements Factory {
        @Override
        public Sender produce() {
            return new MailSender();
        }
    }

    static class SmsSenderFactory implements Factory {
        @Override
        public Sender produce() {
            return new SmsSender();
        }

    }

}
