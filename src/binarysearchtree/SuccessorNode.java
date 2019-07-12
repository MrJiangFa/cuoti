package binarysearchtree;

public class SuccessorNode {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.parent = null;
        Node n2 = new Node(2);
        n1.left = n2;
        n2.parent = n1;
        Node n3 = new Node(3);
        n1.right = n3;
        n3.parent = n1;
        Node n4 = new Node(4);
        n2.left = n4;
        n4.parent = n2;
        Node n5 = new Node(5);
        n2.right = n5;
        n5.parent = n1.left;
        Node n8 = new Node(8);
        n4.left = n8;
        n8.parent = n4;
        Node n9 = new Node(9);
        n9.parent = n4;
        Node n10 = new Node(10);
        n10.parent = n5;
        Node n11 = new Node(11);
        n11.parent = n5;
        Node n6 = new Node(6);
        n6.parent = n3;
        Node n7 = new Node(7);
        n7.parent = n3;
        System.out.println(getSuccessorNode(n11).value);
    }

    public static class Node {
        private Node parent;
        private Node left;
        private Node right;
        private int value;

        Node(int value) {
            this.value = value;
        }
    }

    //遍历后继节点
    public static Node getSuccessorNode(Node node) {
        //对于存在右子树的节点，其后继节点为其右子树的最左节点
        //如果没有右子树，左子树的最后一个节点；向上走，知道找到一个
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            Node left = node.right;
            while (left.left != null) {
                left = left.left;
            }
            return left;
        } else {
            Node par = node.parent;//实现变量复用，缩减代码
            while (par != null&&par.left!=node) {
                node = par;
                par = node.parent;
            }
            return par;
        }
    }
}
