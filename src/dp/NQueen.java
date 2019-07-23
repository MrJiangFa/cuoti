package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 题目描述：如何将n个皇后放置在n*n的棋盘上，并且使得皇后彼此之间不能相互进攻
 * 皇后之间位于同一行、列、斜线（左斜线，右斜线）都有可能相互攻击
 */
public class NQueen {
    //如果在(i,j)位置放置皇后，则以下位置不能放置皇后
    //1.整个i行不能放置;
    //2.整个j列不能放置;
    //3.如果位置(a,b)满足|a-i|=|b-j|

    //逐行放置皇后可以避开1中不能放置的位置
    //record数组中保存已经放置的皇后的位置，record[i]表示在第i行皇后所在的列数
    //1.查看record[j]中是否有相等的值，若有说明(i,j)不能放置皇后
    //2.查看|k-i| ？= |record[k]-j|，若成立，也说明(i,j)不能放置皇后

    /**
     * @param record:record[i]表示第i行放置在j列
     * @param i：第i行
     * @param j：第j列
     * @return
     */
    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param list
     * @param row
     * @param n：皇后的个数，棋盘的长或宽
     * @param record
     */
    public static void putQueen(List<List<String>> list, int row, int n, int[] record) {
        if (row == n) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (record[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                tmp.add(sb.toString());
            }
            list.add(tmp);
            return;
        }
        //for循环对应所有的列，遍历所有的列寻找满足条件的皇后位置
        for (int i = 0; i < n; i++) {
            if (isValid(record, row, i)) {
                record[row] = i;
                putQueen(list, row + 1, n, record);
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        int[] record = new int[n];
        putQueen(list, 0, n, record);
        return list;
    }

    /**
     * 对于LeetCode中的NQueenII，求解满足条件的N皇后位置
     * 采用三个集合set，分别存放已经占据的列，正对角线，反对角线
     * 采用回溯法，求解所有情况
     */
    private final Set<Integer> occupiedCols = new HashSet<Integer>();
    private final Set<Integer> occupiedDiag1s = new HashSet<Integer>();
    private final Set<Integer> occupiedDiag2s = new HashSet<Integer>();

    public int totalNQueens(int n) {
        return totalNQueenHelper(0, 0, n);
    }

    public int totalNQueenHelper(int row, int count, int n) {
        for (int col = 0; col < n; col++) {
            if (occupiedCols.contains(col))
                continue;
            int diag1 = row - col;
            if (occupiedDiag1s.contains(diag1))
                continue;
            int diag2 = row + col;
            if (occupiedDiag2s.contains(diag2))
                continue;
            if (row == n - 1) {
                count++;
            } else {
                occupiedCols.add(col);
                occupiedDiag1s.add(diag1);
                occupiedDiag2s.add(diag2);
                count = totalNQueenHelper(row + 1, count, n);//容易出错的点
                occupiedCols.remove(col);
                occupiedDiag1s.remove(diag1);
                occupiedDiag2s.remove(diag2);
            }
        }
        return count;
    }

    /**
     * 求解NQueen放置方案的第二种解法，参考上述求解具体解的方法
     *
     * @param n
     * @return
     */
    public int totalNQueens2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] record = new int[n];
        putQueen(0, n, record);
        return res;
    }

    private int res = 0;

    public void putQueen(int row, int n, int[] record) {
        if (row == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(record, row, i)) {
                record[row] = i;
                putQueen(row + 1, n, record);
            }
        }
    }

}
