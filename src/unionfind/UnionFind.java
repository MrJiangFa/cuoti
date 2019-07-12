package unionfind;

import java.util.HashMap;
import java.util.List;

public class UnionFind {
    public static class Node {
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    //
    public static class UnionFindSet {
        public HashMap<Node, Node> fatherMap;//key:child,value:head
        public HashMap<Node, Integer> sizeMap;//节点所在集合对应的节点个数

        public UnionFindSet(List<Node> nodes) {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);//初始的时候每个节点自成一个集合，节点的父节点为其自身
                sizeMap.put(node, 1);
            }
        }

        public Node findHead(Node node) {
            Node father = fatherMap.get(node);
            if (father != node) {
                father = findHead(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        //判断两个节点是否属于同一集合
        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node ahead = findHead(a);
            Node bhead = findHead(b);
            if (ahead != bhead) {
                int aSize = sizeMap.get(ahead);
                int bSize = sizeMap.get(bhead);
                if (aSize <= bSize) {
                    fatherMap.put(ahead, bhead);
                    sizeMap.put(bhead, aSize + bSize);
                } else {
                    fatherMap.put(bhead, ahead);
                    sizeMap.put(ahead, aSize + bSize);
                }
            }
        }
    }
    //将边界及岛信息扔到分布式内存中


}
