package array;

/**
 * n个非负整数表示每个宽度为1的柱子的高度，计算按此排列的柱子下雨之后能接多少水；
 */
public class LeetCode42 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int max = findMax(height, 0, height.length - 1);//寻找最高的柱子
        int l = 0, r = height.length - 1;
        while (l < height.length) {
            if (height[l] == max) {
                break;
            } else {
                l++;
            }
        }
        while (r >= 0) {
            if (height[r] == max) {
                break;
            } else {
                r--;
            }
        }
        if (l != r) {
            int midSum = 0;
            for (int i = l + 1; i < r; i++) {
                midSum += height[i];
            }
            int midArea = (r - l - 1) * height[r] - midSum;
            return midArea + getAreaOfR(height, r) + getAreaOfL(height, l);
        }
        return getAreaOfR(height, r) + getAreaOfL(height, l);
    }

    public static int getAreaOfR(int[] height, int index) {
        if (index >= height.length - 1) {
            return 0;
        }
        int maxOfR = findMax(height, index + 1, height.length - 1);//index右半部分的最大值
        int r = height.length - 1;
        while (r > index) {
            if (height[r] == maxOfR) {
                break;
            } else {
                r--;
            }
        }

        int midSum = 0;
        for (int i = index + 1; i < r; i++) {
            midSum += height[i];
        }
        int midArea = (r - index - 1) * height[r] - midSum;
        return midArea + getAreaOfR(height, r);
    }

    public static int getAreaOfL(int[] height, int index) {
        if (index <= 0) {
            return 0;
        }
        int maxOfL = findMax(height, 0, index - 1);//index右半部分的最大值
        int l = 0;
        while (l < index) {
            if (height[l] == maxOfL) {
                break;
            } else {
                l++;
            }
        }

        int midSum = 0;
        for (int i = l + 1; i < index; i++) {
            midSum += height[i];
        }
        int midArea = (index - l - 1) * height[l] - midSum;
        return midArea + getAreaOfL(height, l);
    }

    public static int findMax(int[] height, int left, int right) {
        int res = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (height[i] > res) {
                res = height[i];
            }
        }
        return res;
    }

    private static int trap2(int[] arr) {
        int len = arr.length;
        int res = 0;
        int left = 0, right = len - 1;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= maxLeft)
                    maxLeft = arr[left];
                else
                    res += maxLeft - arr[left];
            } else {
                if (arr[right] >= maxRight)
                    maxRight = arr[right];
                else
                    res += maxRight - arr[right];
            }
        }
        return res;
    }

}
