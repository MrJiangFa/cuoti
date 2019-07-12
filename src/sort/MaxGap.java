package sort;

public class MaxGap {
    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (max == min) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];//表示桶中是否含数
        int[] maxs = new int[len + 1];//记录桶中最大值
        int[] mins = new int[len + 1];//记录桶中最下值
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            mins[bid] = hasNum[i] ? Math.min(nums[i], mins[bid]) : nums[i];
            maxs[bid] = hasNum[i] ? Math.max(nums[i], maxs[bid]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(mins[i] - lastMax, res);
                lastMax = maxs[i];
            }
        }
        return res;
    }
    //求取一个数来自几号桶

    /**
     * @param num：某个数的大小
     * @param len：
     * @param min
     * @param max
     * @return
     */
    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
}
