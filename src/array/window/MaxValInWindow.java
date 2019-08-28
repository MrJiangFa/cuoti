package array.window;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组，一个固定大小的滑动窗口从左向右滑动，求解一个每滑动一次，滑动窗口中的最大值
 * 假设数组为{1,3,4,5,5,7,8}
 * 窗口大小为3，则返回一个数组{4,5,5,7,8}
 * 使用双端队列结构实现快速查找，避免每次查找遍历一遍窗口中所有数据
 * 双端队列 头——尾  大——小
 */
public class MaxValInWindow {
    /**
     * @param arr：所给的数组
     * @param w：窗口的大小——窗口头为最大值，尾为最小值
     * @return 返回一个arr.length-w+1长度的数组表示窗口在向右移动过程中的最大值
     * 复杂度：数组中每个数组只会进队列一次，出队列一次
     */
    protected static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        //双端队列中存放索引
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!list.isEmpty() && arr[list.peekLast()] <= arr[i]) {
                list.pollLast();
            }
            list.addLast(i);
            //减数的逻辑
            if (list.peekFirst() == i - w) {
                list.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[list.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMaxWindow(new int[]{3, 3, 4, 5, 24, 5, 3, 4, 5, 6, 778, 23, 32, 24, 65, 23}, 3)));
    }
}
