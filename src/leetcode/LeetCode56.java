package leetcode;

import java.util.*;

public class LeetCode56 {
    public static void main(String[] args) {
        int[][] p = new int[][]{{1, 4}, {4, 5}};
        int[][] res = merge(p);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return null;
        }
        if (intervals.length < 2) {
            return intervals;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new MyComparator());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            pq.add(intervals[i]);
        }
        int[] first = pq.poll();
        int left = first[0], right = first[1];
        while (!pq.isEmpty()) {
            if ((first = pq.poll())[0] <= right) {
                right = Math.max(right, first[1]);
            } else {
                list.add(new int[]{left, right});
                left = first[0];
                right = first[1];
            }
        }
        list.add(new int[]{left,right});
        int len = list.size();
        int[][] res = new int[len][2];
        for (int i = 0; i < len; i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }

    public static class MyComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }
}
