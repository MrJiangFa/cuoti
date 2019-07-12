package stringtest;

/**
 * 翻转一个整数，-321翻转之后为-123；
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    /**
     * @param x : 翻转x
     * @return
     */
    public static int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            //当数值超过Integer.MAX_VALUE~Integer.MIN_VALUE的范围，if中条件就不成立；
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }

    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        } else if (x > 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(x));
            int index = sb.length() - 1;
            while (sb.charAt(index) == '0') {
                index--;
            }
            swap(sb, 0, index);
            String res = sb.substring(0, index + 1);
            return Long.valueOf(res) > Integer.MAX_VALUE ? 0 : Integer.valueOf(res);
        } else {
            StringBuilder sb = new StringBuilder(String.valueOf(x));
            int index = sb.length() - 1;
            while (sb.charAt(index) == '0') {
                index--;
            }
            swap(sb, 1, index);
            String res = sb.substring(0, index + 1);
            return Long.valueOf(res) < Integer.MIN_VALUE ? 0 : Integer.valueOf(res);
        }
    }

    public static void swap(StringBuilder s, int start, int end) {
        if (start > end) {
            return;
        }
        while (start <= end) {
            char tmp = s.charAt(start);
            s.replace(start, start + 1, String.valueOf(s.charAt(end)));
            s.replace(end, end + 1, String.valueOf(tmp));
            start++;
            end--;
        }
    }

    /**
     * 基本说明：解析一个字符串表示的数值；
     * 例如：+123ab 解析为123
     * -123ba 解析为-123
     * 第一个有效字符为+ - 数字
     * @param str
     * @return
     */
    public static int myAtio(String str) {
        return 0;
    }
}
