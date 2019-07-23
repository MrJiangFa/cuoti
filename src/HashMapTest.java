import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class HashMapTest {
    public static void main(String[] args) {
        System.out.println(new HashMapTest().totalNQueens(2));
    }

    public int totalNQueens(int n) {
        int[] record = new int[n];
        putQueen(0, n, record);
        return res;
    }

    private static int res = 0;

    public boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

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
