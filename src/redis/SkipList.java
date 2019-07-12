package redis;

import java.util.ArrayList;

public class SkipList {
    //跳表中的节点
    public static class SkipListNode {
        public Integer value;
        public ArrayList<SkipListNode> nextNodes; //10 -> 10层 nextNode.get(0)表示第0层的下一个结点；越小层越高，当前节点所在那一列对应的链表

        public SkipListNode(Integer value) {
            this.value = value;
            nextNodes = new ArrayList<>();
        }
    }

    private SkipListNode head;//巨小(系统最小)
    private int maxLevel;//所有数据的最大层
    private int size;//系统中key的个数
    private static final double PROBABLITY = 0.5;

    public SkipList() {
        size = 0;
        maxLevel = 0;
        head = new SkipListNode(null);
        head.nextNodes.add(null);
    }

    public boolean contains(int newValue) {
        return false;
    }

    public void add(Integer newValue) {
        if (!contains(newValue)) {
            size++;
            int level = 0;
            //按照掷色子的原理进行，直到掷出的概率小于0.5时停止，此时的层数就是新增节点的层数；
            while (Math.random() < PROBABLITY) {
                level++;
            }
            while (level > maxLevel) {
                head.nextNodes.add(null);//如果插入的层数大于初始层，则增加head的层数
                maxLevel++;
            }
            SkipListNode newNode = new SkipListNode(newValue);
            SkipListNode current = head;
            do {
                current = findNext(newValue, current, level);
                newNode.nextNodes.add(0, current.nextNodes.get(level));
                current.nextNodes.set(level,newNode);
            } while (level-- > 0);
        }
    }

    public boolean lessThan(int a, int b) {
        return false;
    }

    //同一层上进行寻找，如果下一个结点的值比插入的新值小，则继续向右移动
    private SkipListNode findNext(Integer e, SkipListNode current, int level) {
        SkipListNode next = current.nextNodes.get(level);//
        while (next != null) {
            Integer value = next.value;
            //如果当前值比下一个结点的值小，则截止，将相应点插入；
            if (lessThan(e, value)) {
                break;
            }
            current = next;
            next = current.nextNodes.get(level);
        }
        return current;//此处的current表示当前层最后的小于新插入值的节点
    }

    public static void main(String[] args) {
        int a = 2;
        do{
            System.out.println(a);
        }while(a-->0);
    }

}
