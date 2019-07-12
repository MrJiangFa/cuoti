package leetcode;

/**
 * 一个数组，数组元素表示可以跳的步数，问是否能跳到最后
 */
public class CanJump {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        if (nums.length < 2) {
            return true;
        }
        for (int i = 0, max = 0; i < nums.length; i++) {
            if (nums[i] <= 0 && max <= i) {
                return i == nums.length - 1 ? true : false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
