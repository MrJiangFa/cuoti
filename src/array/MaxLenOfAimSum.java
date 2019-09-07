package array;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个目标数值aim，求数组中 子数组 满足累和为aim的最大长度
 * 比如{7,1,2,3,1,7} aim=7,则最终结果为4-->1+2+3+1=7,且此时长度为4
 * 解题思路：map数据结构保存从0开始出现最早的累加和(key),及其位置i(value);
 * 如果0至当前位置的和为sum，则从map中寻找最找出现的sum-aim然后记录下对应的长度
 */
public class MaxLenOfAimSum {
    public static int process(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);//累加和为0，最早出现的位置为-1
        int sum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (hashMap.containsKey(sum - aim)) {
                res = Math.max(res, i - hashMap.get(sum - aim));
            }
            if (!hashMap.containsKey(sum)) {
                hashMap.put(sum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(process(new int[]{7}, 7));
    }
}
