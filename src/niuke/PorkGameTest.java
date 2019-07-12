package niuke;

import java.util.Arrays;
import java.util.Scanner;

public class PorkGameTest {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int n  = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(getResult(n,arr));
    }
    public static int getResult(int n,int[] array){
        int sum = 0;
        int temp = n%2;
        for(int i = n;i>0;--i){
            if ((i%2-temp)==0){
                sum+=array[i];
            }
            else{
                sum-=array[i];
            }
        }
        return sum;
    }
}
