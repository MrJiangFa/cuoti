package binarysearchtree;

/**
 * 递归和非递归方法的二叉树遍历都使用了O(h)的空间复杂度，h表示二叉树的高度；
 *
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

    //morris遍历实现O(N)时间复杂度，O(1)空间复杂度的遍历方式
    public static void morrisIn(Node head) {
        if (head == null) {

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

    /**
     * 寻找BST中最小值对应的节点
     *
     * @param t
     * @return
     */
    private Node<AnyType> findMin(Node<AnyType> t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    /**
     * 寻找 BST 中最大值对应的节点
     *
     * @param t
     * @return
     */
    private Node<AnyType> findMax(Node<AnyType> t) {
        if (t == null) {
            return null;
        } else if (t.right == null) {
            return t;
        }
        return findMax(t.right);
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
        } else if (t.left != null && t.right != null) {//是在comparedResult==0的前提下
            t.element = findMin(t.right).element;      //找到右子树的最小值对应的节点，并将其代替被删除的节点，同时将右子树中对应最小值的节点删除
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
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
