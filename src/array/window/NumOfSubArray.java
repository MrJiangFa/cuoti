package array.window;

import array.SubarrayMaxSum;

import java.util.LinkedList;

public class NumOfSubArray extends  SubarrayMaxSum{
    /**
     * @param arr:待求解数组
     * @param num：子数组满足 max-min<=num
     * @return: 返回所有满足max-min<=num的子数组的个数
     */
    public static int getNumOfSub(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;
        int L = 0;
        int R = 0;
        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        while (L < arr.length) {
            while (R < arr.length) {
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]) {
                    qmin.pollLast();
                }
                qmin.addLast(R);
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                    qmax.pollLast();
                }
                qmax.addLast(R);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                R++;
            }
            if (qmin.peekFirst() == L) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == L) {
                qmax.pollFirst();
            }
            res += R - L;
            L++;
        }
        return res;

    }



    public static void main(String[] args) {

        System.out.println(getNumOfSub(new int[]{2, 2}, 1));
    }
}
