package dp.knapsack;

public class CompleteKnapsack {
    public static void main(String[] args) {
        System.out.println(process(new int[]{1, 2, 4}, 5, 0));
        System.out.println(process(new int[]{1, 2, 4}, 3, 0));
        System.out.println(process(new int[]{1, 2, 4}, 5, 1));
        System.out.println(process(new int[]{1, 2, 4}, 5, 2));
        System.out.println(process(new int[]{1, 2, 4}, 9, 2));
        System.out.println(process(new int[]{1, 2, 5}, 11, 2));
        System.out.println(leastCoin(new int[]{1, 2, 5}, 11));
        System.out.println(process(new int[]{1, 2}, 2, 1));
    }

    public static int leastCoinDp(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }
//        for (int j = 0; j <){
//
//        }
        return 0;
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
                    continue;
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
