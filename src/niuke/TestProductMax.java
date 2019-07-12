package niuke;

import java.util.Arrays;
import java.util.Scanner;
public class TestProductMax{
    public static long test(long[] a) throws Exception{
        Arrays.sort(a);
        int len  = a.length;
        if(len<3)
            throw new Exception("数组长度小于3");
        if(len==3) {
            System.out.println(a[0] * a[1] * a[2]);
            return a[0] * a[1] * a[2];
        }
        return (a[len-1]*a[len-2]*a[len-3]>a[len-1]*a[0]*a[1])?a[len-1]*a[len-2]*a[len-3]:a[len-1]*a[0]*a[1];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        long[] a = new long[size];
        for(int i = 0;i<size;i++){
            a[i]=sc.nextLong();
        }
        try{
            System.out.println(test(a));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
