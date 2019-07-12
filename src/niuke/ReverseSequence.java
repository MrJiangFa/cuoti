package niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class ReverseSequence {
    public static void main(String[] args){
        //System.out.println(getResult(10,5));
        int j = 4;
        for(int i = 10;i>5;--i){
            System.out.println(i);
        }
        List<Integer> numberList = Arrays.asList(2,4,1,3,5);
        for(int i = 0;i<numberList.size();++i)
        {
            int v = numberList.get(i);
            if(v%2 == 0)
            {
                numberList.remove(v);//删除的是元素，而非下标
            }
        }
    }
    public static int getResult(int n,int m){
        int[] temp = new int[n];
        for(int i = 0;i<n;i++){
            if (((i-i%m)/m)%2==0){
                temp[i]=-(i+1);
            }
            else{
                temp[i]=i+1;
            }
        }
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum+=temp[i];
        }
        return sum;
    }
}
