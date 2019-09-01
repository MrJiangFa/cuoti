package array;

/**
 * 求一个包含负数的数组的最大子数组
 * 例子：{1,2，-1,4，-2}
 * <p>
 * 数组中最大乘积
 */
public class SubarrayMaxSum {
    public static int maxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }

    //浮点数构成的最大乘积
    //问题分解为0-i上最大乘积

    /**
     * 1. i位置为0
     * 2. 前i-1位置的最大值乘上i位置的数 100 1 2
     * 3. 前i-1位置的最小值乘上i位置的数 100 -1 -2
     * 4. 乘积只为i位置的数
     * <p>
     * a=最大(i-1)，b=最小(i-1),max，遍历
     */
    private static int maxProduct(int[] arr) {
        int a = arr[0], b = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int tmp = a;
            int tmp2 = b;
            a = Math.min(tmp*arr[i],Math.min(tmp2*arr[i],arr[i]));
            b = Math.max(tmp*arr[i],Math.max(tmp2*arr[i],arr[i]));
            max = Math.max(b,max);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{100, -2,-1}));
    }

}
