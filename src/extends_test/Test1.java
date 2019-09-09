package extends_test;

/**
 * 1. 子类继承父类时，如果
 * 2. 实例化一个子类时，先初始化父类的静态变量，静态初始化，然后加载子类的静态变量、静态初始化块，然后调用父类非静态初始化块，再调用子类非静态初始化块
 *      然后调用父类构造器，再调用子类构造器；
 */
class Parent {
    public int a = 1;
    static int b = 1;

    public Parent(int a){
        this.a = a;
    }

    static void print(){
        System.out.println("父类静态方法");
    }

    static {
        System.out.println("父类静态初始化块");
    }

    {
        System.out.println("父类非静态初始化块");
    }
}

public class Test1 extends Parent {
    public int a = 0;

    public Test1(int a){
        super(a);
    }


    {
        System.out.println("子类非静态初始化块");
    }

    static {
        System.out.println("子类静态初始化块");
    }

    public static void main(String[] args) {
//        Parent p = new Test1();
//        System.out.println(p.a);
//        System.out.println(Test1.b);
        Test1 test = new Test1(2);
    }

}
