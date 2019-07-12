package recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(candidates);
        recursive(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    public static int recursive(List<List<Integer>> list, List<Integer> tmpList, int[] candidates, int target, int start) {
        if (target < 0) {
            return -1;
        } else if (target == 0) {
            list.add(new ArrayList<>(tmpList));
            return 0;
        } else {
            for (int i = start; i < candidates.length; i++) {
                tmpList.add(candidates[i]);
                int res = recursive(list, tmpList, candidates, target - candidates[i], i);
                tmpList.remove(tmpList.size() - 1);
                if (res < 0) {
                    break;
                }
            }
            return 1;
        }
    }
}
