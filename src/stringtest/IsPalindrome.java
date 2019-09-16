package stringtest;

/**
 * leetcode5:求一个字符串中的最长回文子串
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cabbad"));
    }

    private String res = "";
    public String longestPalindrome2(String s) {
        if(s==null||s.length()==0)
            return res;
        for(int i = 0;i<s.length();i++){
            for(int j = i;j<s.length();j++){
                process(s,i,j);
            }
        }
        return res;
    }
    private boolean process(String s,int i,int j){
        if(j-i<3){
            if(s.charAt(i)==s.charAt(j)){
                if(j-i+1>res.length()){
                    res = s.substring(i,j+1);
                }
                return true;
            }
            return false;
        }
        if(process(s,i+1,j-1)&&s.charAt(i)==s.charAt(j)){
            if(j-i+1>res.length()){
                res = s.substring(i,j+1);
            }
            return true;
        }
        return false;
    }

    //采用递归做超出时间限制
    public static String longestPalindrome(String s) {
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
    //i 从 arr.length-1 开始向前，j 从 i 开始向后 i~j 之间是否为回文串；
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
