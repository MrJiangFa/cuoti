package stringtest;

public class Leetcode718_Longest_Common_Substring {

    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("iewihwetglghflkewjfilesdj", "fdsioujfioashejgioershoighisdrfghjio"));
    }

    public static int longestCommonSubstring(String str1, String str2) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                res = Math.max(res, commonSubString(str1, str2, i, j));
            }
        }
        int res2 = longestCommonSubstringByDP(str1, str2);
        return res == res2 ? 0 : 1;
    }

    /**
     * 对于str1,str2，求这两个字符串的最长公共子串
     * str1-i   str2-j
     * 以 i，j 为结尾的字符串公共子串的长度
     */
    public static int commonSubString(String str1, String str2, int i, int j) {
        if (i == 0 || j == 0) {
            return str1.charAt(i) == str2.charAt(j) ? 1 : 0;
        }
        int before = commonSubString(str1, str2, i - 1, j - 1);
        return str1.charAt(i) == str2.charAt(j) ? before + 1 : 0;
    }


    public static int longestCommonSubstringByDP(String str1, String str2) {
        int lenOfStr1 = str1.length();
        int lenOfStr2 = str2.length();
        int[][] dp = new int[lenOfStr1][lenOfStr2];
        int max = 0;
        for (int j = 0; j < lenOfStr2; j++) {
            dp[0][j] = str1.charAt(0) == str2.charAt(j) ? 1 : 0;
            max = Math.max(max, dp[0][j]);
        }
        for (int i = 0; i < lenOfStr1; i++) {
            dp[i][0] = str1.charAt(i) == str2.charAt(0) ? 1 : 0;
            max = Math.max(max, dp[i][0]);
        }
        for (int i = 1; i < lenOfStr1; i++) {
            for (int j = 1; j < lenOfStr2; j++) {
                dp[i][j] = str1.charAt(i) == str2.charAt(j) ? dp[i - 1][j - 1] + 1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
