package sort;

import java.util.Arrays;

public class QuickSort<AnyType extends Comparable<? super AnyType>> {
    //基本类型不能作为Comparable传递，但是包装类可以，因为他们实现了Comparable接口；
    public static void main(String[] args) {
        Integer[] a = new Integer[100000];
        for (int i = 0; i < 100000; i++) {
            if ((i & 0x1) == 1) {
                a[i] = -i;
            } else {
                a[i] = i;
            }
        }
        System.out.println(Arrays.toString(a));
        QuickSort<Integer> qs = new QuickSort<>();
        qs.quickSort(a);
        System.out.print(Arrays.toString(a));
    }

    public void quickSort(AnyType[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(AnyType[] arr,int l,int r){
        if(l<r){
            swap(arr,l+((int)((r-l+1)*Math.random())),r);
            int[] p = partition(arr,l,r);
            quickSort(arr,l,p[0]-1);
            quickSort(arr,p[1]+1,r);
        }
    }

    //采用荷兰国旗问题优化快排，将与中间值相同的值固定好位置，避免重复排序
    public int[] partition(AnyType[] arr, int l, int r) {
        int less = l - 1, more = r, cur = l;
        while (cur < more) {
            if (arr[cur].compareTo(arr[r]) < 0) {
                swap(arr, ++less, cur++);
            } else if (arr[cur].compareTo(arr[r]) > 0) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }


    private void swap(AnyType[] arr, int i, int j) {
        AnyType temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void insertSort(AnyType[] arr, int left, int right) {
        int len = right - left + 1;
        if (arr == null || len < 2) {
            return;
        }
        for (int i = left + 1; i < right; i++) {
            for (int j = i-1; j >= left && arr[j].compareTo(arr[j + 1]) > 0; j--) {
                swap(arr, j, j + 1);
            }
        }
    }
}
