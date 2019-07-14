package dp;

/**
 * 给定数组和目标aim，求数组元素相加可否表示为aim
 */
public class AimSum {
    public static void main(String[] args) {
        System.out.println(aimSum(new int[]{1, 2, 3}, 7));
    }
    /**
     * 题目所给条件为数组中所有元素为正整数
     *
     * @param nums
     * @param aim
     * @return
     */
    public static boolean aimSum(int[] nums, int aim) {
        if (aim <= 0 || nums == null) {
            return false;
        }
        return process(nums, nums.length - 1, aim);
    }

    /**
     * dp法
     *
     * @param nums
     * @param aim
     * @return
     */
    private static boolean process2(int[] nums, int aim) {
        boolean[][] res = new boolean[nums.length][aim + 1];
        for (int i = 0; i <= aim; i++) {
            res[0][i] = i == nums[0];
            if (i == aim && res[0][i]) {
                return true;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= aim; j++) {
                if (!res[i - 1][j]) {
                    if (j - nums[i] > 0) {
                        res[i][j] = res[i - 1][j - nums[i]];
                    } else {
                        res[i][j] = false;
                    }

                } else {
                    res[i][j] = true;
                }
                if (j == aim && res[i][j]) {
                    return true;
                }
            }
        }
        return res[nums.length - 1][aim];
    }

    /**
     * 递归法
     *
     * @param nums
     * @param i
     * @param aim
     * @return
     */
    private static boolean process(int[] nums, int i, int aim) {
        if (i == 0) {
            return aim == nums[i];
        }
        if (!process(nums, i - 1, aim)) {
            return process(nums, i - 1, aim - nums[i]);
        } else {
            return true;
        }
    }

}
