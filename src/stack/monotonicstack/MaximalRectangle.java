package stack.monotonicstack;

import java.util.Stack;

/**
 * 单调栈的应用
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        System.out.print(maxRecSize(new int[][]{{1, 0, 1, 1}}));
    }

    //求给定矩阵中，只含1的矩阵的最大的1的个数
    //基本思路是将题目转化为但单调栈求解直方图问题
    public static int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRectFromBottom(height), maxArea);
        }
        return maxArea;
    }

    //求解直方图问题中的最大矩阵的元素个数
    public static int maxRectFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {//元素相等的直方图也可以计算
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(curArea, maxArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(curArea, maxArea);
        }
        return maxArea;
    }
}
