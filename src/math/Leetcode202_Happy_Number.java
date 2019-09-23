package math;

/**
 * 快乐数：经过若干次各个位数字平方求和之后，最终结果等于1的数称之为快乐数；
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Leetcode202_Happy_Number {
    public static void main(String[] args) {

    }

    public static boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while (slow != fast);
        if (slow == 1)
            return true;
        return false;
    }

    private static int digitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
}
