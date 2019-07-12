package recursive;

import java.util.ArrayList;
import java.util.List;

public class MatrixSpiralPrinting {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        spiralOrder(matrix);

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int tr = 0, br = matrix.length - 1;
        int tc = 0, bc = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();
        while (tr <= br && tc <= bc) {
            if (tr == br) {
                for (int i = tc; i <= bc; i++) {
                    list.add(matrix[tr][i]);
                }
            } else if (tc == bc) {
                for (int i = tr; i <= br; i++) {
                    list.add(matrix[i][tc]);
                }
            } else {
                int curR = tr;
                int curC = tc;
                while (curC != bc) {
                    list.add(matrix[tr][curC++]);
                }
                while (curR != br) {
                    list.add(matrix[curR++][bc]);
                }
                while (curC != tc) {
                    list.add(matrix[br][curC--]);
                }
                while (curR != tr) {
                    list.add(matrix[curR--][tc]);
                }
            }
            tr++;
            tc++;
            br--;
            bc--;
        }
        return list;
    }
}
