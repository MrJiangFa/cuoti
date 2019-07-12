package dp;

public class MaxSubArray {
    //递归版本
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length<2){
            return nums[0];
        }
        int res = nums[0];
        for(int i = 0;i<nums.length;i++){
            res = Math.max(res,getMax(nums,0,nums.length-1,i));
        }
        return res;
    }
    private int getMax(int[] nums,int left,int right,int i){
        if(i==left){
            return nums[left];
        }
        int max = nums[i];
        return Math.max(getMax(nums,left,right,i-1)+max,max);
    }
    //dp版本
    public int maxSubArray1(int[] nums){
        int len = nums.length;
        if(nums==null||len==0){
            return 0;
        }
        if(len<2){
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        for(int i = 1;i<len;i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
