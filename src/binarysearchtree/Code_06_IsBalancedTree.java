package binarysearchtree;

/**
 * leetcode110
 * 判断一棵树是否为平衡二叉树？
 * 一个平衡二叉树的特点在于：任意节点的左右子树高度差不超过1
 * <p>
 * 解题思路：从上至下，通过遍历每一个节点的高度差是否超过1来改变一个全局变量的boolean变量来表示是否为平衡二叉树；
 */
public class Code_06_IsBalancedTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    private static boolean res = true;

    //暴力法：从上至下
    public static boolean isBalance(Node head) {
        maxDepth(head);
        return res;
    }

    private static int maxDepth(Node head) {
        if (head == null) {
            return 0;
        }
        int l = maxDepth(head.left);
        int r = maxDepth(head.right);
        if (Math.abs(l - r) > 1)
            res = false;
        return Math.max(l, r) + 1;
    }

    /**
     * 从下至上，非暴力法，提前阻断
     *
     * @param args
     */
    public static void main(String[] args) {


    }

}
