package recursive.backtrack;

import java.util.*;

public class Code_04_Print_All_Permutations {

    public static void permutations1(String str) {
        char[] chs = str.toCharArray();
        process1(chs, 0);
    }

    public static void process1(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        for (int j = i; j < chs.length; j++) {
            swap(chs, i, j);
            process1(chs, i + 1);
            swap(chs, i, j);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    /**
     * 采用回溯法，对于new ArrayList<>() 当其长度等于数组长度时就返回
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permutations2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null) {
            return list;
        }
        process2(list, new ArrayList<>(), nums);
        return list;
    }

    public static void process2(List<List<Integer>> list, List<Integer> tmpList, int[] nums) {
        if (tmpList.size() == nums.length) {
            list.add(tmpList);
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!tmpList.contains(nums[j])) {
                tmpList.add(nums[j]);
                process2(list, tmpList, nums);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    /**
     * 采用迭代法或递推法，首先向结果的list中加入一个list，然后取出该list，
     * 向list中的0-list.size()位置插入数组中的某一个元素
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permutations3(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int n : nums) {
            int size = res.size();
            for (; size > 0; size--) {
                List<Integer> r = res.pollFirst();
                for (int i = 0; i <= r.size(); i++) {
                    List<Integer> t = new ArrayList<Integer>(r);
                    t.add(i, n);
                    res.add(t);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        permutations3(new int[]{1, 2, 3});
    }

}
