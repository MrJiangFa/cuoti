import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FinalTest extends Instrument{
    public static void main(String[] args){

    }
}
abstract class Instrument{
    static int a;
    public void play(){
        System.out.println(1);
    }
    public static void main(String[] args){
        System.out.println(a);
    }
    static void get(){};
}
interface DefaultTest{
    int a =2;
    public default void get(){}
    public static void  set(){}
}
