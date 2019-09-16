package stringtest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 最长不重复子串
 */
public class MaxLenOfNonrepSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 基本思路：
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int res = 0;
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = index + 1; j < i; j++) {
                if(s.charAt(j)==s.charAt(i)){
                    index = j;
                    break;
                }
            }
            res = Math.max(i-index,res);
        }
        return res;
    }

}
