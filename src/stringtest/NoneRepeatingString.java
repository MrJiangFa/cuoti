package stringtest;

public class NoneRepeatingString {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int n = s.length();
        int res = 0;
        int index=-1;//当前字符的前一个字符左边出现的最后一个相同字符
        for(int i = 0;i<n;i++){
            for(int j =index+1;j<i;j++){
                if(s.charAt(j)==s.charAt(i)){
                    index = j;
                    break;
                }
            }
            res = Math.max(res,i-index);
        }
        return res;
    }
}
