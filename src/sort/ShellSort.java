package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args){
        Integer[] arr = new Integer[]{1,2,1,54,5,15,4,54,51,2,1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static <AnyType extends Comparable<? super AnyType>> void shellSort(AnyType[] arr){
        int j;
        for(int gap = arr.length>>1;gap>0;gap=gap>>1){
            for(int i=gap;i<arr.length;i++){
                AnyType temp = arr[i];
                for(j=i;j>=gap&&temp.compareTo(arr[j-gap])<0;j-=gap){
                    arr[j]=arr[j-gap];
                }
                arr[j]=temp;
            }
        }
    }
}
