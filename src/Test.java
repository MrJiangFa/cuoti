import java.util.concurrent.BlockingQueue;

class Node<K, V> {
    final int hash;
    final K key;
    V value;
    Node<K, V> next;

    Node(int hash, K key, V value, Node<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public final K getKey() {
        return key;
    }

    public final V getValue() {
        return value;
    }

    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }
}

class TreeNode<K, V> extends Node<K, V> {
    TreeNode<K, V> parent;
    TreeNode<K, V> left;
    TreeNode<K, V> right;
    TreeNode<K, V> prev;
    boolean red;

    TreeNode(int hash, K key, V value, Node<K, V> next) {
        super(hash, key, value, next);
    }

    final TreeNode<K, V> root() {
        for (TreeNode<K, V> r = this, p; ; ) {
            if ((p = r.parent) == null) {
                return r;
            }
            r = p;
        }
    }

    //以hash 值作为比较值，构成二叉查找树
    public TreeNode<K, V> find(int h, Object k, Class<?> kc) {
        TreeNode<K, V> p = this;
        do {
            int ph, dir;
            K pk;
            TreeNode<K, V> pl = p.left, pr = p.right, q;
            if ((ph = p.hash) > h) {
                p = pl;
            } else if (ph < h) {
                p = pr;
            } else if ((pk = p.key) == k || k != null && k.equals(pk)) {

                return p;
            }
        } while (p != null);
        return null;
    }

}

public class Test<K, V> {
    Node<K, V>[] table;
    int threshold;//进行resize()的阈值
    static final int MAX_CAPACITY = 1 << 30;//table的最大容量
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public static void main(String[] args) {
        String a = new String("a");
        String b = "a";
        System.out.println(a != null && a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a == b);
    }

    public Node<K, V>[] resize() {
        Node<K, V>[] oldTab = this.table;
        int oldCap = oldTab == null ? 0 : oldTab.length;
        int oldThre = threshold;
        int newCap, newThre = 0;
        if (oldCap > 0) {
            if (oldCap >= MAX_CAPACITY) {  //如果table的容量大于允许的MAX_CAPACITY，则无需进行扩容
                threshold = Integer.MAX_VALUE;
                return oldTab;
            } else if ((newCap = oldCap << 1) < MAX_CAPACITY && oldCap > DEFAULT_INITIAL_CAPACITY) {
                newThre = oldThre << 1;
            }
        } //如果 oldCap == 0
        else if (oldThre > 0) {
            newCap = oldThre;
        } //如果 oldCap = 0,oldThre = 0
        else {
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThre = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        }
        //对于table的oldCap>0 && oldCap< DEFAULT_INITIAL_CAPACITY 时，需要进行下方的初始化过程；
        if (newThre == 0) {
            float ft = (float) newCap * DEFAULT_LOAD_FACTOR;
            newThre = (newCap < MAX_CAPACITY && ft < (float) MAX_CAPACITY) ? (int) ft : Integer.MAX_VALUE;
        }
        threshold = newThre;
        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int i = 0; i < oldCap; i++) {
                Node<K, V> e;
                if ((e = oldTab[i]) != null) {
                    oldTab[i] = null;
                    // rehash过程1：
                    if (e.next == null) {
                        newTab[e.hash & (newCap - 1)] = e;
                    } else if (e instanceof Node) {

                    }
                }
            }
        }
        return null;
    }


    public static int tableSizeFoe(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30 ? 1 << 30 : n + 1);
    }
}