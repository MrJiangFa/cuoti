import java.util.Hashtable;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        FutureTask futureTask1 = new FutureTask(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, null);

    }
}
