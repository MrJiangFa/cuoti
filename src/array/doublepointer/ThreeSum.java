package array.doublepointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 返回数组array中，所有满足a+b+c=0的三元组a,b,c
 */
public class ThreeSum {
    public static void main(String[] args) {
//        fourSum(new int[]{0,0,0,0},0);
        System.out.println(ThreeSum.class.getCanonicalName());
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums==null||nums.length<4){
            return res;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i==0||nums[i]!=nums[i-1]){
                threeSum(nums,nums[i],target-nums[i],i+1,nums.length-1,res);
            }
        }
        return res;
    }
    public static void threeSum(int[] nums,int first,int target,int low,int high,List<List<Integer>> res3){
        int numsLen = nums.length;
        if(high-low<2||3*nums[0]>target||3*nums[numsLen-1]<target){
            return;
        }
        for(int i = low;i<=high-2;i++){
            if(i==low||nums[i]!=nums[i-1]){
                int sum = target-nums[i];
                int left = i+1,right = high;
                while(left<right){
                    if(nums[left]+nums[right]==sum){
                        res3.add(Arrays.asList(first,nums[i],nums[left],nums[right]));
                        while(left<right&&nums[left]==nums[left+1]){
                            left++;
                        }
                        while(left<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(nums[left]+nums[right]>sum){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 3 || nums == null) {
            return res;
        }
        //基本思路：i从0-nums.length-3,对每个以i为起始值的三元组,寻找满足和为0的三元组
        //首尾两个指针同时前进寻找满足条件的数值
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if ((nums[lo] + nums[hi]) == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi - 1] == nums[hi]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if ((nums[lo] + nums[hi]) < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}
