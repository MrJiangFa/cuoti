package stringtest;

public class KMP {
    public static void main(String[] args) {
        String s = "";
        System.out.println(s.equalsIgnoreCase(""));
    }

    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = s.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArr(str2);
        while (i1 < s.length() && i2 < m.length()) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else {
                if (next[i2] == -1) {
                    i1++;
                } else {
                    i2 = next[i2];
                }
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    /**
     * next[0]=-1,next[1]=0,next[i]= 最长公共前后缀长度
     *
     * @param str2
     * @return
     */
    public static int[] getNextArr(char[] str2) {
        if (str2.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;//来到的位置
        int cn = 0;//cn表示跳到的位置
        while (i < next.length) {
            if (str2[i - 1] == str2[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}


