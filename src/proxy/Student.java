package proxy;

public class Student implements Person{

    @Override
    public void sayHello(String content, int age) {
        System.out.println("strudent say hello"+content+" "+age);
    }

    @Override
    public void sayGoodBye(boolean seeAgain, double time) {
        System.out.println("student saygoodbye"+time+" "+seeAgain);
    }
}
