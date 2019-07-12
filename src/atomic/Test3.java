package atomic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.get(0));
    }
    private static String binaryString(int num) {
        StringBuilder result = new StringBuilder();
        int flag = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int val = (flag & num) == 0 ? 0 : 1;
            result.append(val);
            num <<= 1;
        }
        return result.toString();
    }
    public static String getCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs.length == 0||strs==null) {
            return "";
        }
        char[] chars = strs[0].toCharArray();
        int numOfCommonPrefix = Integer.MAX_VALUE;
        for (int i = 1; i < strs.length; i++) {
            int index = 0;
            int curNumOfCommonPrefix = 0;
            while (index < strs[i].length() && index < chars.length) {
                if (strs[i].charAt(index) == chars[index]) {
                    curNumOfCommonPrefix++;
                }else{
                    break;
                }
                index++;
            }
            numOfCommonPrefix = Math.min(numOfCommonPrefix, curNumOfCommonPrefix);
        }
        return numOfCommonPrefix == 0 ? "" : strs[0].substring(0, numOfCommonPrefix);
    }
}

