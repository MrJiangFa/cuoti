package dp;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    //如果在(i,j)位置放置皇后，则一下位置不能放置皇后
    //1.整个i行不能放置;
    //2.整个j列不能放置;
    //3.如果位置(a,b)满足|a-i|=|b-j|

    //逐行放置皇后可以避开1中不能放置的位置
    //record数组中保存已经放置的皇后的位置，record[i]表示在第i行皇后所在的列数
    //1.查看record[j]中是否有相等的值，若有说明(i,j)不能放置皇后
    //2.查看|k-i| ？= |record[k]-j|，若成立，也说明(i,j)不能放置皇后

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
     * @param n
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
        for (int i = 0; i < n; i++) {
            if (isValid(record, row, i)) {
                record[row] = i;
                putQueen(list, row + 1, n, record);
            }
        }
    }
    public static List<List<String>> solveNQueens(int n){
        List<List<String>> list  = new ArrayList<>();
        int[] record = new int[n];
        putQueen(list,0,n,record);
        return list;
    }


}
