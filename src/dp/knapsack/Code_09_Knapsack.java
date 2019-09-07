package dp.knapsack;

import java.util.*;

public class Code_09_Knapsack {


    public static int maxValue(int[] c, int[] p, int bag) {
        return process(c, p, c.length, bag);
    }


    /**
     * process(int[] weights,int[] values,int i,int alreadyWeight,int bag)
     * process()表示的物理意义为前i个物品的最佳组合对应的价值，j表示对应的重量/体积
     * 第i个物体可以选择装与不装，
     *
     * @param weights
     * @param values
     * @param i
     * @param bag
     * @return
     */
    public static int process(int[] weights, int[] values, int i, int bag) {
        if (i <= 0) {
            return 0;
        }
        if (bag <= 0) {
            return 0;
        }
        return Math.max(process(weights, values, i - 1, bag),
                bag >= weights[i - 1] ? values[i - 1] + process(weights, values, i - 1, bag - weights[i - 1]) : process(weights, values, i - 1, bag));
    }

    public static int processByDP(int[] weights, int[] values, int bag) {
        int[][] dp = new int[weights.length + 1][bag + 1];
        for (int i = 0; i <= weights.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= bag; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= bag; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], j >= weights[i - 1] ? values[i - 1] + dp[i - 1][j - weights[i - 1]] : dp[i - 1][j]);
            }
        }
        return dp[weights.length][bag];
    }


    public static int maxValue2(int[] c, int[] p, int bag) {
        int[][] dp = new int[c.length + 1][bag + 1];
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + c[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
                }
            }
        }
        return dp[0][0];
    }

    /**
     * @param n：A B两个字符序列中元素个数
     * @param i：i位置——索引
     */

    private static int process(String[] A, String[] B, int n, int i) {
        if (i == 0) {
            return A[i].equals(B[i]) ? 1 : 0;
        }
        int before = process(A, B, n, i - 1);
        if (A[i].equals(B[i])) {
            return before + 1;
        }
        int[] indexs = getSameFromeLast(A, B, i - 1);
        for (int a = indexs[0] + 1; a < i; a++) {
            if (B[i].equals(A[a])) {
                return before + 1;
            }
        }
        for (int b = indexs[1] + 1; b < i; b++) {
            if (A[i].equals(B[b])) {
                return before + 1;
            }
        }
        return before;
    }

    /**
     * 寻找从i开始向前第一个相同的元素
     *
     * @param A
     * @param B
     * @param i
     * @return
     */
    private static int[] getSameFromeLast(String[] A, String[] B, int i) {
        Map<String, Integer> mapOfA = new HashMap<>();
        Map<String, Integer> mapOfB = new HashMap<>();
        int[] res = new int[]{-1, -1};
        while (i >= 0) {
            if (mapOfB.containsKey(A[i])) {
                res[0] = i;
                res[1] = mapOfB.get(A[i]);
                return res;
            } else if (!mapOfA.containsKey(A[i])) {
                mapOfA.put(A[i], i);
            }
            if (mapOfA.containsKey(B[i])) {
                res[0] = mapOfA.get(B[i]);
                res[1] = i;
                return res;
            } else if (!mapOfB.containsKey(B[i])) {
                mapOfB.put(B[i], i);
            }
            i--;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(process(new String[]{"1", "5", "4", "2", "3"}, new String[]{"5", "4", "3", "2", "1"}, 5, 4));
        System.out.println(Arrays.toString(getSameFromeLast(new String[]{"1", "5", "4", "2", "3"}, new String[]{"5", "4", "3", "2", "1"},2)));
    }

}
