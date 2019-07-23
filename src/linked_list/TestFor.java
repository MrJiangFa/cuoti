package linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFor {
    public static void main(String[] args){
        int j;
        int[] a=new int[10];
        for(j=0;j<10;){
            a[j++]=j;
        }
        System.out.println(Arrays.toString(a));
        for(int n : a){
            System.out.print(n);
        }
        List<Integer> list = new ArrayList<>();
    }
}
