package recursive.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 打印一个字符串（数组）中的所有子序列
 * 将字符串转化为字符数组，数组中每一个元素都有两种选择，即选和不选
 * 当前位置i所作的决策与之前0---i-1状态所作的决策无关，即当前所作的决策无需考虑之前的状态，此题无后效性
 * <p>
 * subsets问题：leetcode
 */
public class Code_03_Print_All_Subsquences {

    public static void main(String[] args) {
//        printSub("abcd".toCharArray(),0,"");
//        List<List<Integer>> list = subsets(new int[]{1,2,3});
//        Object[] obs = list.toArray();
//        Arrays.sort(obs);
//        for(List<Integer> l : list){
//            System.out.println(Arrays.toString(l.toArray()));
//        }
        int i = 0;
        for(;i<10;i++){
            if(i==9){
                break;
            }
        }
        System.out.println(i);
    }

    /**
     * @param chars：待求的字符串数组
     * @param i：i位置
     * @param res：前以状态的结果    此题无后效性，一旦状态标志i和res确定
     */
    public static void printSub(char[] chars, int i, String res) {
        if (i == chars.length) {
            System.out.println(res);
            return;
        }
        printSub(chars, i + 1, res);
        printSub(chars, i + 1, res + chars[i]);
    }

    /**
     * 采用递归的方式实现回溯法
     *
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(new ArrayList<>(), list, 0, nums);
        return list;
    }

    public static void backtrack(List<Integer> tmpList, List<List<Integer>> list, int i, int[] nums) {
        list.add(new ArrayList<>(tmpList));
        for (int index = i; index < nums.length; index++) {
            tmpList.add(nums[index]);
            backtrack(tmpList, list, index + 1, nums);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    /**
     * Initially, one empty subset [[]]
     * Adding 1 to []: [[], [1]];
     * Adding 2 to [] and [1]: [[], [1], [2], [1, 2]];
     * Adding 3 to [], [1], [2] and [1, 2]: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]].
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());    //先加一个没有元素的列表
        for (int i = 0; i < nums.length; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(list.get(j));
                tmp.add(nums[i]);
                list.add(tmp);
            }
        }
        return list;
    }

    /**
     * 对于数组中的任意元素，只有在子集和中和不在子集和中两种情况；
     * 事先划分好结果对立中有多少个
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets3(int[] nums) {
        int len = nums.length, p = 1 << len;
        List<List<Integer>> list = new ArrayList<>(p);
        for (int i = 0; i < p; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < len; j++) {
                if (((i >> j) & 1) == 1) {
                    list.get(i).add(nums[j]);
                }
            }
        }
        return list;
    }
}
