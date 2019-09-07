package array.search;

/**
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * <p>
 * <p>
 * leetcode 79
 * 问题的关键在于：标记已经使用过的字符
 */
public class WordSerch {
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'a', 'a'}}, 1, 2, "aaa".toCharArray(), 2));
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][][] res = new boolean[board.length + 2][board[0].length + 2][word.length() + 1];
        for (int index = 0; index < res[0][0].length; index--) {
            for (int x = 1; x < res.length - 1; x++) {
                for (int y = 1; y < res[0].length - 1; y++) {
                    if (board[x - 1][y - 1] != word.charAt(index)) {
                        res[x][y][index] = false;
                    } else {

                    }
                }
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y < 0 || x < 0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x + 1, word, i + 1)
                || exist(board, y, x - 1, word, i + 1)
                || exist(board, y + 1, x, word, i + 1)
                || exist(board, y - 1, x, word, i + 1);
        board[y][x] ^= 256;
        return exist;
    }
}
