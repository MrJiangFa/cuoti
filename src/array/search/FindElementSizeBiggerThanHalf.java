package array.search;

import java.util.Arrays;

/**
 * 给定一个数组，寻找该数组中出现次数超过一半的元素，如果存在输出该元素的值，否则返回0
 */
public class FindElementSizeBiggerThanHalf {
    /**
     * 首先将数组排序，如果存在超过半数的元素，那么排序后一定位于arr.len/2处
     * 时间复杂度为排序复杂度——》快排：O(NlogN)
     *
     * @param arr
     * @return
     */
    public int moreThanHalfNumber1(int[] arr) {
        return 0;
    }

    /**
     * 分形页思路
     * 每次去掉数组中不同的两个数，知道剩下的最后一个或最后两个元素，如果存在超过半数的元素，则一定在其中；
     *
     * @param arr
     * @return
     */
    public int moreThanHalfNumber(int[] arr) {
        int len = arr.length;
        if(arr==null||arr.length==0){
            return 0;
        }
        int[] tmp = new int[len];
        for(int i = 0;i<len;i++){
            tmp[i] = arr[i];
        }
    }
}
