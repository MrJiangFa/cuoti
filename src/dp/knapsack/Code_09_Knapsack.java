package dp.knapsack;

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

    public static void main(String[] args) {
        int[] c = {200, 600, 100, 180, 300, 450};
        int[] p = {6, 10, 3, 4, 5, 8};
        int bag = 1000;
        System.out.println(processByDP(c, p, bag));
        System.out.println(maxValue2(c, p, bag));
        System.out.println(maxValue(c, p, bag));

    }

}
