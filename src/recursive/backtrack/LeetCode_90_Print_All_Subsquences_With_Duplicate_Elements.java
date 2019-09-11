package recursive.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的数组 nums
 * 返回该数组所有可能的子集
 * 注意：解集不能包含重复元素
 * <p>
 * 解题思路：对数组进行排序，对于重复出现的元素，在子序列不允许重复的情况下，结果集中应该只考虑重复元素出现的次数
 */
public class LeetCode_90_Print_All_Subsquences_With_Duplicate_Elements {
    public List<List<Integer>> subsetWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ) {
            int count = 0;//系统元素的个数
            while (count + i < nums.length && nums[count + i] == nums[i])
                count++;
            int previousSize = list.size();
            for (int k = 0; k < previousSize; k++) {
                List<Integer> tmp = new ArrayList<>(list.get(k));
                for (int j = 0; j < count; j++) {
                    tmp.add(nums[i]);
                    list.add(new ArrayList<>(tmp));
                }
            }
            i += count;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(3));
        String s = Integer.toBinaryString(3);
        for (int i = 0; i < Byte.SIZE - 3; i++) {
            s = "0" + s;
        }
        System.out.println(s);//补全二进制长度，进行位图法的后续
    }
}
