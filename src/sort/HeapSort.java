package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort<AnyType extends Comparable<? super AnyType>> {
    public static void main(String[] args) {
        HeapSort<Integer> hs = new HeapSort<>();
        int[] arr = new int[]{10, 6, 4, 78, 2, 34, 5, 53, 126534, 534, 354};
//        hs.heapSort(arr);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public void heapSort(AnyType[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int heapSize = arr.length;
        for (int i = 0; i < heapSize; i++) {
            heapInsert(arr, i);
        }
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    //建堆的时间复杂度为O(N)
    public void heapInsert(AnyType[] arr, int index) {
            //index=0时，-1/2 = 0表示的也是0位置的点
            while ((arr[index].compareTo(arr[(index - 1) / 2])) > 0) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
    }

    /**
     * 当改变已经建好堆中的某一个数值
     *
     * @param arr
     * @param index
     * @param heapSize:需要维持大根堆的数组长度
     */
    public void heapify(AnyType[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = (left + 1 < heapSize && arr[left].compareTo(arr[left + 1]) < 0) ? left + 1 : left;
            largest = arr[largest].compareTo(arr[index]) > 0 ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }

    public void swap(AnyType[] arr, int i, int j) {
        AnyType tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int heapSize = arr.length;
        for (int i = 0; i < heapSize; i++) {
            heapInsert(arr, i);
        }
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        while (left < size) {
            int largest = (left + 1 < size && arr[left + 1] > arr[left]) ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }


}
