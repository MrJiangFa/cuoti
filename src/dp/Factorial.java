package dp;

public class Factorial {
    //n!问题

    //汉诺塔问题
    //时间复杂度为O(2^n)   T(n)= T(n-1)+1+T(n-1)，等比数列，时间复杂度为。。
    //N:1-N
    //开始全部停留在from中
    public static void process(int N, String from, String to, String help) {
        if (N == 1) {
            System.out.println("move 1 from " + from + " to " + to);
        } else {
            process(N - 1, from, help, to);//将N-1个移动到help中
            System.out.println("move " + N + " from " + from + " to " + to);
            process(N - 1, help, to, from);
        }
    }

    //打印所有子序列
    public static void printAllSub(char[] str, int i, String res) {
        if (i == str.length) {
            System.out.println(res);
            return;
        }
        printAllSub(str, i + 1, res);
        printAllSub(str, i + 1, res + String.valueOf(str[i]));
    }

    public static void main(String[] arsg) {
//        process(3,"左","中","右");

    }

    //正数矩阵，从（i，j)出发，到达最右下角位置，最小路径
    //复杂度很高
    //
    public static int walk(int[][] matrix, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }
        if (i == matrix.length - 1) {
            return matrix[i][j] + walk(matrix, i, j + 1);
        }
        if (j == matrix[0].length - 1) {
            return matrix[i][j] + walk(matrix, i + 1, j);
        }
        int right = walk(matrix, i, j + 1);//右边位置
        int down = walk(matrix, i + 1, j);//下边位置
        return matrix[i][j] + Math.min(right, down);
    }

    //数组中数据累加能否构成某一指定数
    public static boolean isSum(int[] arr, int sum, int aim) {
        return false;
    }


}
