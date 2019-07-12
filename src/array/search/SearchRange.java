package array.search;

import java.util.Arrays;

public class SearchRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1,2,3,3,3,4,4,5,5,6,6,7},8)));
    }
    public static int[] searchRange(int[] nums, int target) {
        return search(0,nums.length-1,nums,target);
    }
    public static int[] search(int left,int right,int[] nums,int target){
        if(left>right){
            return new int[]{-1,-1};
        }else if(left==right){
            return nums[left]==target?new int[]{left,left}:new int[]{-1,-1};
        }else{
            int mid = (left+right)/2;
            if(nums[mid]==target){
                int s1 = 0,e1 = mid;
                int s2 = mid,e2 = right;
                int mid1 = 0,mid2 = 0;
                while(s1<e1){
                    mid1 = (s1+e1)/2;
                    if(target>nums[mid1]){
                        s1 = mid1+1;
                    }else{
                        e1 = mid1;
                    }
                }
                while(s2<e2){
                    mid2 = (s2+e2)/2;
                    if(target<nums[mid2]){
                        e2 = mid2-1;
                    }else if(nums[mid2+1]==target){
                        s2 = mid2+1;
                    }else{
                        s2 = mid2;
                        break;
                    }
                }
                return new int[]{s1,s2};
            }else if(target>=nums[left]&&target<nums[mid]){
                return search(left,mid-1,nums,target);
            }else if(target>nums[mid]&&target<=nums[right]){
                return search(mid+1,right,nums,target);
            }else{
                return new int[]{-1,-1};
            }
        }
    }
}
