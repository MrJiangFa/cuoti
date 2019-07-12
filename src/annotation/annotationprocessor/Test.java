package annotation.annotationprocessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = in.nextInt();
        }
        List<List<Integer>> list = permuteUnique(height);
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            int j = 0;
            for (; j < n; j++) {
                if (j == 0) {
//                    System.out.println(Math.abs(list.get(i).get(j)-list.get(i).get(n-1))>m);
                    if (Math.abs(list.get(i).get(j) - list.get(i).get(n - 1)) > m ||
                            Math.abs(list.get(i).get(j) - list.get(i).get(j + 1)) > m) {
                        break;
                    }
                } else if (j == n - 1) {
                    if (Math.abs(list.get(i).get(j) - list.get(i).get(0)) > m ||
                            Math.abs(list.get(i).get(j) - list.get(i).get(j - 1)) > m) {
                        break;
                    }
                } else {
                    if (Math.abs(list.get(i).get(j) - list.get(i).get(j - 1)) > m ||
                            Math.abs(list.get(i).get(j) - list.get(i).get(j + 1)) > m) {
                        break;
                    }
                }
            }
            if (j == n) {
                res++;
            }
        }
        System.out.println(res / n);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public static void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, res);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
