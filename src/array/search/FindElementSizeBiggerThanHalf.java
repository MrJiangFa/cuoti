package array.search;

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
    public int moreThanHalfNumber2(int[] arr) {
        int len = arr.length;
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[i] = arr[i];
        }
        for (int i = 0; i < len; i++) {
            if (tmp[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if (tmp[j] != tmp[i] && tmp[j] != 0) {
                    tmp[i] = 0;
                    tmp[j] = 0;
                    break;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (tmp[i] != 0) {
                res = tmp[i];
            }
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (tmp[i] == res) {
                count++;
            }
        }
        if (count > len / 2) {
            return res;
        }
        return 0;
    }

    /**
     * 时间复杂度为O(N)的解法
     */
    public int moreThanHalfNumber3(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int num = array[0], count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == num) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                num = array[i];
                count = 1;
            }
        }
        //验证
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return num;
        }
        return 0;
    }
}
