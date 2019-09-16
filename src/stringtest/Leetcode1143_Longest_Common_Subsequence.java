package stringtest;

/**
 * 求两个字符串 str1，str2，对于 str1 能包含所有 str2 中所有字符的子串，求 str1 该子串的最短长度；
 * <p>
 * leetcode 1143：最长公共子序列
 * <p>
 * leetcode 583：给定单词word1,word2，找到使得word1和word2相同所需的最小步数，每步可以删除任意一个字符串中的字符；
 * 思路：找到两个字符串的最长公共子序列，然后删除需要进行的步数即为删除公共子序列所剩下的字符个数
 * <p>
 * leetcode 1092
 * <p>
 * leetcode 1062
 * <p>
 * leetcode 516
 */
public class Leetcode1143_Longest_Common_Subsequence {
    /**
     * leetcode1143：求两个字符串的最长公共子序列
     * <p>
     * 基本思想：s1，s2 上的位置 i, j（包含i,j)之前的最长公共子序列
     * 如果s1,s2在i,j 处的字符相等，则 dp[i][j] = dp[i-1][j-1]+1;
     * 如果不相等，则 dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
     *
     * @param s1
     * @param s2
     * @return
     */
    private int leetcode1143ByDP(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        dp[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
        for (int i = 1; i < s1.length(); i++) {
            dp[i][0] = s1.charAt(i) == s2.charAt(0) ? 1 : dp[i - 1][0];
        }
        for (int j = 1; j < s2.length(); j++) {
            dp[0][j] = s1.charAt(0) == s2.charAt(j) ? 1 : dp[0][j - 1];
        }
        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                dp[i][j] = s1.charAt(i) == s2.charAt(j) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[s1.length() - 1][s2.length() - 1];
    }

    private int leetcode1143(String s1, String s2, int i, int j) {
        if (i == 0) {
            for (int k = 0; k <= j; k++) {
                if (s2.charAt(k) == s1.charAt(i)) {
                    return 1;
                }
            }
            return 0;
        }
        if (j == 0) {
            for (int k = 0; k <= i; k++) {
                if (s1.charAt(k) == s1.charAt(j)) {
                    return 1;
                }
            }
            return 0;
        }
        return s1.charAt(i) == s2.charAt(j) ? leetcode1143(s1, s2, i - 1, j - 1) + 1 :
                Math.max(leetcode1143(s1, s2, i - 1, j), leetcode1143(s1, s2, i, j - 1));
    }


    public static void main(String[] args) {
        System.out.println('2');
    }
}
