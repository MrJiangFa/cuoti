package sort;

import java.util.Arrays;

/**
 * 基数排序：
 */
public class Code_07_RadixSort {

    // only for no-negative value
    public static void radixSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    //返回数组中最大值是几位数
    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }
    //https://www.cnblogs.com/skywang12345/p/3603669.html

    /**
     * 寻找数组中的最大值，计算其位数——maxbit()
     * 从个位开始，对数组中数据进行排序，然后在上一次排序基础上再对高位进行排序
     * 0-9 10个桶，从各位开始
     *
     * @param arr
     * @param begin
     * @param end
     * @param digit：数组中最大值的位数
     */
    public static void radixSort(int[] arr, int begin, int end, int digit) {
        final int radix = 10;
        int i = 0, j = 0;

        int[] bucket = new int[end - begin + 1];
        //从各位开始，d = 1 表示个位
        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];
            //获得每个数的第d位数，
            for (i = begin; i <= end; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = end; i >= begin; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j]-1] = arr[i];
                count[j]--;
            }
            for (i = begin, j = 0; i <= end; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    private void radixS(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            max = Math.max(max, value);
        }
        int maxBit = String.valueOf(max).length();
        int[] count = new int[10];
        for (int i = 1; i <= maxBit; i++) {
            for (int value : arr) {
                count[(value / (int) Math.pow(10, i - 1)) % 10]++;
            }
            for (int k = 1; k < count.length; k++) {
                count[k] += count[k - 1];
            }
            for (int j = 0; j < arr.length; j++) {
                int b = (arr[j] / (int) Math.pow(10, i - 1)) % 10;

            }
        }
    }


    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        int[] ress = Arrays.copyOf(arr, arr.length);
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
//        int testTime = 500000;
//        int maxSize = 100;
//        int maxValue = 100000;
//        boolean succeed = true;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            radixSort(arr1);
//            comparator(arr2);
//            if (!isEqual(arr1, arr2)) {
//                succeed = false;
//                printArray(arr1);
//                printArray(arr2);
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//        int[] arr = generateRandomArray(maxSize, maxValue);
//        printArray(arr);
//        radixSort(arr);
//        printArray(arr);
        int[] arr = new int[]{2,3,1,45,32,4,5,6,23};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
