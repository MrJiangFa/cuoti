package print_rectangle;

/**
 * 先打印外圈，再打印内圈；
 * 旋转打印一个矩形
 */
public class RotaryPrinting {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 4, 3}, {3, 4, 5, 6}, {5, 56, 6, 7}};
        sprialOrderPrint(arr);
    }

    public static void sprialOrderPrint(int[][] m) {
        int tR = 0;
        int tC = 0;
        int bR = m.length - 1;
        int bC = m[0].length - 1;
        while (tR <= bR && tC <= bC) {
            printEdge(m, tR++, tC++, bR--, bC--);
        }
    }

    public static void printEdge(int[][] m, int tR, int tC, int bR, int bC) {
        if (tR == bR) {
            for (int i = tC; i <= bC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        } else if (tC == bC) {
            for (int i = tR; i <= bR; i++) {
                System.out.print(m[i][tC] + " ");
            }
        } else {
            int curR = 0, curC = 0;
            while (curC != bC) {
                System.out.print(m[tR][curC++]+" ");
            }
            while (curR != bR) {
                System.out.print(m[curR++][bC]+" ");
            }
            while (curC != tC) {
                System.out.print(m[bR][curC--]+" ");
            }
            while (curR != tR) {
                System.out.print(m[curR--][tC]+" ");
            }
        }
    }
}
