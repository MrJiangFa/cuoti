package leetcode;

public class LeetCode58 {
    public static void main(String[] args){
        System.out.println(lengthOfLastWord("jfdsklfja"));
    }
    public static int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        String[] ss = s.split(" ");
        return ss[ss.length-1].length();
    }
}
