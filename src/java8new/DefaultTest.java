package java8new;

import java.util.Collection;

public class DefaultTest {
    private interface Father {
        default void test(){
            System.out.println("父类 default 方法");
        }
        static void test2(){

        }
    }
}
