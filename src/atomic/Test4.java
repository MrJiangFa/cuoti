package atomic;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class Test4 {
    public static void main(String[] args) {
        final int[] arr = new int[3];
        arr[1] = 2;
        arr[2] = 3;
        arr[1] = 1;

    }

    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (!hashSet.contains(array[i])) {
                hashSet.add(array[i]);
            } else {
                hashSet.remove(array[i]);
            }
        }
        int[] tmp = new int[2];
        int i = 0;
        for (Integer n : hashSet) {
            tmp[i++] = n;
        }
        num1[0] = tmp[0];
        num2[0] = tmp[1];
    }
}
