package array;

import java.util.HashMap;

/**
 * 将一个数组随意划分为若干子数组，求解最优划分方案 --> 对应的子数组亦或和为0的子数组个数最多的情况
 * 比如：3,2,1,0,1,2,3,0
 * 当按照如下方式划分：{3,2,1}{0}{1,2,3}{0}，亦或和为0的子数组个数最多为4个
 * 假设对于0-i位置已经进行了完美划分，使得0-i上子数组的亦或和为0 的个数最多，此时分两种情况讨论：
 * 1. 包含i位置的子数组亦或和不为0
 * 此时0 -- i-1 上的最优子数组个数等雨 0 -- i，即dp[i]=dp[i-1]
 * 证明：i位置有没有，包不包含对于最终解无影响；
 * <p>
 * 2. 包含i位置的子数组亦或和为0
 * 假设最后部分为k-i，则k一定是离i位置最近满足亦或和为0的子数组；
 * 即k-i之间肯定不存在子数组使得j-i 亦或和为0的子数组；
 * dp[i] = dp[k-1]+1; --> 0--i位置上亦或和为xor,找到亦或和最晚出现xor，即为k位置
 */
public class MaxNumOfSubArrayOfXOR0 {
    public static int process(int[] arr) {
        int xor = 0;
        int res = 0;
        int[] dp = new int[arr.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);//亦或和为0最早出现的位置为-1
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            if (hashMap.containsKey(xor)) {//最后一个子数组的亦或和为0
                int pre = hashMap.get(xor);
                dp[i] = pre == -1 ? 1 : dp[hashMap.get(xor)] + 1;
            }
            if (i > 0) {
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            hashMap.put(xor, i);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(process(new int[]{3,2,1,0,1,2,3,0}));
    }
}
