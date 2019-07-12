package atomic;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1}, {1,1,1},{1,1,1}};
        System.out.println(getResult(matrix));
    }


    public static int getResult(int[][] matrix) {
        if (matrix == null || matrix.length == 1 && matrix[0].length == 1) {
            return 0;
        }
        SortedMap<Integer, Integer> h1 = new TreeMap<>(), h2 = new TreeMap<>();//采用HashMap+PriorityQueue代替
        int count1 = 0, count2 = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ((i + j) % 2 == 0) {
                    if (!h1.containsKey(matrix[i][j])) {
                        h1.put(matrix[i][j], 1);
                    } else {
                        int tm = h1.get(matrix[i][j]);
                        tm++;
                        h1.put(matrix[i][j], tm);
                    }
                    count1++;
                } else {
                    if (!h2.containsKey(matrix[i][j])) {
                        h2.put(matrix[i][j], 1);
                    } else {
                        int tm = h2.get(matrix[i][j]);
                        tm++;
                        h2.put(matrix[i][j], tm);
                    }
                    count2++;
                }
            }
        }
        ArrayList<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        h1.values().forEach(n->list1.add(n));//TreeMap的遍历效果
        h2.values().forEach(n->list2.add(n));
        int res1 = 0, res2 = 0;
        res1 = list1.get(0) >= list2.get(0) ? list1.get(0) : (list1.size() < 2 ? 0 : list1.get(1));
        res2 = list2.get(0) > list1.get(0) ? list2.get(0) : (list2.size() < 2 ? 0 : list2.get(1));
        return count1 - res1 + count2 - res2;
    }
}