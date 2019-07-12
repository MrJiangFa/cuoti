package sort;

import java.util.Arrays;
import java.util.HashMap;

public class BubbleSort {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        int[] array = new int[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = (int) (Math.pow(-1, i) * i);
        }
//        int[] a = new int[]{3,4,1,2,6,7,45,4,4,7,3,2,6,7,43,434,34534,2,44};
//        System.out.println(a);
//        System.out.println(getResult(a));
        long before = System.currentTimeMillis();
        System.out.println(Arrays.toString((array)));
        long after = System.currentTimeMillis();
        System.out.println("冒泡排序: " + (after - before) + "ms");
        long before2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(selectionSort(array)));
        long after2 = System.currentTimeMillis();
        System.out.println("选择排序: " + (after2 - before2) + "ms");
        long before3 = System.currentTimeMillis();
        System.out.println(Arrays.toString(insertSort(array)));
        long after3 = System.currentTimeMillis();
        System.out.println("选择排序: " + (after3 - before3) + "ms");
    }

    /**
     * 相邻数之间比较，然后不断上浮；
     *
     * @param arr
     * @return
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int j = 0; j < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    //选择排序
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    //插入排序
    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
//        arr[i]=arr[i]^arr[j];
//        arr[j]=arr[i]^arr[j];
//        arr[i]=arr[i]^arr[j];
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //对数器
    public static int[] generateRandomArray(int size, int value) {
        //Math.random()->double[0,1)
        //(int)((size+1)*Math.random())->[0,size]整数，等概
        //size
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
        }
        return arr;
    }

}
