package dp.knapsack;

/**
 * leetcode322:硬币问题
 * 给定不同面额的硬币coins，一个总金额 amount
 * 编写函数计算可以凑成总金额所需的最少硬币数
 */
public class CompleteKnapsack {
    public static void main(String[] args) {
//        System.out.println(process(new int[]{1, 2, 4}, 5, 0));
//        System.out.println(process(new int[]{1, 2, 4}, 3, 0));
//        System.out.println(process(new int[]{1, 2, 4}, 5, 1));
//        System.out.println(process(new int[]{1, 2, 4}, 5, 2));
//        System.out.println(process(new int[]{1, 2, 4}, 9, 2));
//        System.out.println(process(new int[]{1, 2, 5}, 11, 2));
//        System.out.println(leastCoin(new int[]{1, 2, 5}, 11));
//        System.out.println(process(new int[]{1, 2}, 2, 1));
        int count=0;
        System.out.println(1+count++);
    }

    public static int leastCoinDp(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        int[][] dp = new int[coins.length][amount + 1];
        for (int col = 0; col < dp[0].length; col++) {
            dp[0][col] = col < coins[0] ? -1 : col % coins[0] == 0 ? col / coins[0] : -1;
        }
        for (int row = 1; row < dp.length; row++) {
            dp[row][0] = 0;
        }
        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[0].length; col++) {
                if (col < coins[row]) {
                    dp[row][col] = dp[row - 1][col];
                } else {
                    int tmp = col;
                    int res = Integer.MAX_VALUE;
                    int count = 0;
                    for (; tmp >= 0; tmp -= coins[row]) {
                        if (dp[row - 1][tmp] != -1) {
                            res = Math.min(res, dp[row - 1][tmp] + count++);
                        } else {
                            count++;
                        }
                    }
                    dp[row][col] = res == Integer.MAX_VALUE ? -1 : res;
                }
            }
        }
        return dp[coins.length - 1][amount];
    }

    public static int leastCoin(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        return process(coins, amount, coins.length - 1);
    }

    /**
     * 前i个包含第i个coin，构成amount的目标金币数所用的最少金币
     *
     * @param coins
     * @param amount
     * @param i
     * @return
     */
    private static int process(int[] coins, int amount, int i) {
        if (amount == 0) {
            return 0;
        }
        if (i == 0) {
            if (amount < coins[0]) {
                return -1;
            } else {
                if (amount % coins[0] == 0) {
                    return amount / coins[0];
                } else {
                    return -1;
                }
            }
        }

        int tmp = amount;
        int resOfIth = Integer.MAX_VALUE;

        if (amount >= coins[i]) {
            int numOfIth = 0;
            for (; tmp >= 0; tmp -= coins[i]) {
                int t = process(coins, tmp, i - 1);
                System.out.println("tmp:" + tmp + " i:" + (i - 1) + " t:" + t);
                if (t != -1) {
                    resOfIth = Math.min(resOfIth, t + numOfIth);
                    System.out.println("tmp:" + tmp + " i:" + (i - 1) + " t:" + t + " resOfIth:" + resOfIth);
                    numOfIth++;
                } else {
                    numOfIth++;
                }
            }
            if (resOfIth == Integer.MAX_VALUE) {
                return -1;
            } else {
                return resOfIth;
            }
        } else {
            return process(coins, amount, i - 1);
        }
    }
}
