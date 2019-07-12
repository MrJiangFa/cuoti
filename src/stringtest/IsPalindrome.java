package stringtest;

public class IsPalindrome {
    public static void main(String[] args) {
        String tmp = "bb";
        IsPalindrome isPalindrome = new IsPalindrome();
        String t = "";
        boolean[][] arr = IsPalindrome.dp(tmp);
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i][j] && (j - i + 1) > t.length()) {
                    t = tmp.substring(i, j + 1);
                }
            }
        }
        System.out.println(t);
    }

    //采用递归做超出时间限制
    public String longestPalindrome(String s) {
        if (s.length() < 2 || s == null) {
            return s;
        }
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j) && (j - i + 1) > tmp.length()) {
                    tmp = s.substring(i, j + 1);
                }
            }
        }
        return tmp;
    }

    public static boolean isPalindrome(String s, int i, int j) {
        if (i == j) {
            return true;
        }
        if (j - i == 1) {
            return s.charAt(i) == s.charAt(j);
        }
        if (isPalindrome(s, i + 1, j - 1) && s.charAt(i) == s.charAt(j)) {
            return true;
        } else {
            return false;
        }
    }

    //采用动态规划
    public static boolean[][] dp(String s) {
        int len = s.length();
        boolean[][] arr = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (j == i) {
                    arr[i][j] = true;
                } else if (j - i == 1) {
                    arr[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    arr[i][j] = (s.charAt(i) == s.charAt(j) && arr[i + 1][j - 1]);
                }
            }
        }
        return arr;
    }
}