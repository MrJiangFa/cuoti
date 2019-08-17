package array.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DictionaryOrder {
    public static void main(String[] args) {
//        int[] arr = new int[]{53941, 38641, 31525, 75864, 29026};
        int[] arr = new int[]{53941, 38641, 31525, 75864, 29026, 12199, 83522, 58200, 64784, 80987};
        //int[] arr = new int[]{12199, 38641, 31525, 75864, 53941, 29026, 80987, 58200, 64784, 83522};
        process(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void process(int[] arr, int i) {
        if (i == 0) {
            return;
        }
        process(arr, i - 1);
        String result = concat(arr, 0, i);
        String ith = String.valueOf(arr[i]);
        int resN = i;
        Map<String, Integer> map = new HashMap<>();
        for (int k = 0; k < i; k++) {
            if ((arr[k] + arr[i]) % 2 != 0) {
                map.put(concat(arr, 0, k - 1) + ith + concat(arr, k, i - 1), k);
            }
        }
        for (String key : map.keySet()) {
            if (key.compareTo(result) < 0) {
                result = key;
                resN = map.get(key);
            }
        }
        int t = arr[i];
        for (int index = i; index >= resN; index--) {
            if (index == resN) {
                arr[index] = t;
            } else {
                arr[index] = arr[index - 1];
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static String concat(int[] arr, int start, int end) {
        if (start > end) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
