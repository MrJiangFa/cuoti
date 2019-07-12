package list;

/**
 * 以k个一组翻转链表
 * 如：1->2->3->4->2  当k=2时，返回结果为2->1->4->3->2
 */
public class ReverseListByK {
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        Node res = reverseKGroup(head, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    /**
     * 采用递归法
     *
     * @param head
     * @param k
     * @return
     */
    public static Node reverseKGroup(Node head, int k) {
        Node cur = head;
        int count = 0;
        while (cur != null && count < k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            //对于前k个结点，让其指向cur结点，原来的下一个结点作为新的头部
            while (count-- > 0) {
                Node tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }

    /**
     * Reverse a link list between begin and end exclusively
     * an example:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |
     * begin       end
     * after call begin = reverse(begin, end)
     * <p>
     * 0->3->2->1->4->5->6
     * |  |
     * begin end
     *
     * @return the reversed list's 'begin' node, which is the precedence of node end
     */
    //非递归法
    public static Node reverseKGroup2(Node head, int k) {
        Node dum = new Node(0);
        dum.next = head;
        Node begin = dum;
        int index = 0;
        while (head != null) {
            index++;
            if (index % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dum.next;
    }

    public static Node reverse(Node begin, Node end) {
        Node prev = begin.next;
        Node cur = prev.next;
        while (cur != end) {
            prev.next = cur.next;
            cur.next = begin.next;
            begin.next = cur;
            cur = prev.next;
        }
        return prev;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
