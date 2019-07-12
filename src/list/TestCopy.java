package list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class TestCopy {
    public static void main(String[] args){
        int[] a = {2,33,4,5,2,1};
        int[] b = a;
        b[2]=0;
        System.out.println(Arrays.toString(a));
    }
}
