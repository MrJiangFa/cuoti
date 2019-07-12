package list;

import java.util.HashMap;

public class DeleteNthNode {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node deletNthNode(Node head, int n) {
        HashMap<Integer, Node> hashMap = new HashMap<>();
        Node tmp = head;
        int index = 1;
        while (tmp != null) {
            hashMap.put(index++, tmp);//使用hashMap规避空节点问题
            tmp = tmp.next;
        }
        int size = hashMap.size();
        if (size <= 1) {
            return null;
        }
        if (n == 1) {
            hashMap.get(size - 1).next = null;//让导数第二个节点指向空
        } else if (n == size) {
            head = head.next;
        } else {
            hashMap.get(size - n).next = hashMap.get(size - n + 2);
        }
        return head;
    }

    /**
     * 方法：设置虚拟节点start，以及快慢指针，快指针先走n+1步，停止，然后快慢指针一起走直到遇到null
     * @param head
     * @param n
     * @return
     */
    public static Node deleteNthNode2(Node head, int n) {
        Node start = new Node(0);
        Node fast = start, slow = start;
        start.next = head;
        for(int i = 1;i<=n+1;i++){
            fast = fast.next;
        }
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

}
