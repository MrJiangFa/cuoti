package stringtest;

/**
 * 计算两个非负实数的计算结果，只能用字符串的形式——大数相加
 */
public class SumOfTwoNonnegativeNumber {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(5);
        sumOfTwoLinkedListOfLeetcode2(l1, l2);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 借鉴两个链表相加
     *
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode sumOfTwoLinkedListOfLeetcode2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return dummy.next;
    }

    /**
     * 计算两个非负整数的和，以字符串表示
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String leetcode415AddStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            res.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return res.reverse().toString();
    }
}
