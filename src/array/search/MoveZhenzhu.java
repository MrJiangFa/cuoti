package array.search;

import java.util.Arrays;

public class MoveZhenzhu {
    public static void main(String[] args) {
        System.out.println(getMaxInterval(4, 1000, new int[]{1, 4, 998, 995}));
    }

    /**
     * @param N：珍珠个数
     * @param L：位置
     * @return
     */
    private static int getMaxInterval(int N, int L, int[] arr) {
        int sum = 0;
        int mid = L / 2;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] > mid ? (arr[i] - L) : arr[i];
        }
        int average = sum / N;
        int[] tmp = new int[N];
        for (int i = 0; i < N; i++) {
            tmp[i] = average - (N / 2 - i);
        }
        int res = 0;
        int[] newArrr = new int[N];
        for (int i = 0; i < N; i++) {

        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            int t = arr[i] > mid ? (arr[i] - L) : arr[i];
            res += Math.abs(t - tmp[i]);
        }
        return res;

    }
}
