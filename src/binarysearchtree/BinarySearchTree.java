package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 递归和非递归方法的二叉树遍历都使用了O(h)的空间复杂度，h表示二叉树的高度；
 * @param <AnyType>
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    private Node<AnyType> root;

    BinarySearchTree() {
        this.root = null;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();
        bt.insert(5);
        for (int i = 0; i < 10; i++) {
            bt.insert(i);
        }
    }

    public boolean contains(AnyType element) {
        return contains(element, root);
    }

    private boolean contains(AnyType element, Node<AnyType> t) {
        if (t == null) {
            return false;
        }
        if (element.compareTo(t.element) < 0) {
            return contains(element, t.left);
        } else if (element.compareTo(t.element) > 0) {
            return contains(element, t.right);
        } else {
            return true;
        }
    }

    public Node<AnyType> findMin() {
        return findMin(root);
    }

    public Node<AnyType> findMax() {
        return findMax(root);
    }

    private Node<AnyType> findMin(Node<AnyType> t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    private Node<AnyType> findMax(Node<AnyType> t) {
        if (t == null) {
            return null;
        } else if (t.right == null) {
            return t;
        }
        return findMax(t.left);
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    private Node<AnyType> insert(AnyType x, Node<AnyType> t) {
        if (t == null) {
            return new Node<AnyType>(x, null, null);
        }
        if (x.compareTo(t.element) < 0) {
            t.left = insert(x, t.left);
        } else if (x.compareTo(t.element) > 0) {
            t.right = insert(x, t.right);
        } else
            ;
        return t;
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    private Node<AnyType> remove(AnyType x, Node<AnyType> t) {
        if (t == null) {
            return t;
        }
        int comparedResult = x.compareTo(t.element);
        if (comparedResult < 0) {
            t.left = remove(x, t.left);
        } else if (comparedResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null & t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t != null) ? t.left : t.right;
        }
        return t;
    }

    private void preOrder(Node<AnyType> head) {
        if (head != null) {
            System.out.print(head.element + " ");
            preOrder(head.left);
            preOrder(head.right);
        }
    }

    private void midOrder(Node<AnyType> head) {
        if (head != null) {
            midOrder(head.left);
            System.out.print(head.element + " ");
            midOrder(head.right);
        }
    }

    private void printTreeByPostOrder(Node<AnyType> t) {
        if (t != null) {
            printTreeByPostOrder(t.left);
            printTreeByPostOrder(t.right);
            System.out.print(t.element + " ");
        }
    }


    //先序遍历非递归实现
    private void preOrderRecur(Node<AnyType> head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.element + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
            System.out.println();
        }
    }

    //中序遍历非递归打印
    //当前节点为空，从栈中拿一个打印，当前节点向右
    //当前节点不为空，当前节点压入栈，当前节点往左
    private void midOrderRecur(Node<AnyType> head) {
        System.out.print("mid-order: ");
        if(head!=null) {
            LinkedList<Node<AnyType>> stack = new LinkedList<>();
            while (head != null || !stack.isEmpty()) {
                if (head != null) {//向将左边界全部压入栈中
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.element+" ");
                    head = head.right;
                }
            }
        }
    }

    //后序遍历
    private void postOrderRecur(Node<AnyType> head){
        System.out.print("post-order: ");
        if(head!=null){
            Stack<Node<AnyType>> s1 = new Stack<>();
            Stack<Node<AnyType>> s2 = new Stack<>();
            s1.push(head);
            while(!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if(head.left!=null){
                    s1.push(head.left);
                }
                if(head.right!=null){
                    s1.push(head.right);
                }
            }
            while(!s2.isEmpty()){
                System.out.println(s2.pop().element+" ");
            }
        }
        System.out.println();
    }

    private int depth(Node<AnyType> t) {
        if (t == null) {
            return 0;
        }
        int l = depth(t.left);
        int r = depth(t.right);
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }

    //递归实现
    private void printTreeByLevelOrder(Node<AnyType> t) {

    }

    //非递归实现
    private void printTreeByLevelOrder1(Node<AnyType> t) {
        Queue<Node<AnyType>> queue = new LinkedList<>();
        queue.offer(t);
        Node<AnyType> currentNode;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            System.out.print(currentNode.element + " ");
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
    }

    //morris遍历实现O(N)时间复杂度，O(1)空间复杂度的遍历方式
    public static void morrisIn(Node head){
        if(head==null){

        }
    }


    private static class Node<AnyType> {
        AnyType element;
        Node<AnyType> right;
        Node<AnyType> left;

        Node(AnyType element) {
            this(element, null, null);
        }

        Node(AnyType element, Node right, Node left) {
            this.element = element;
            this.right = right;
            this.left = left;
        }
    }
}
