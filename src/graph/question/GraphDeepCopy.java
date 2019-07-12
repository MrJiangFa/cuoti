package graph.question;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphDeepCopy {
    static class Node {
        int val;
        List<Node> neighbours;

        Node(int val, List<Node> neighbours) {
            this.val = val;
            this.neighbours = neighbours;
        }

        Node() {
        }
    }

    /**
     * 给定无向连通图一个节点的引用，返回该图的深拷贝
     *
     * @param n
     * @return
     */
    public static Node cloneGraph(Node n) {
        HashMap<Integer, Node> map = new HashMap<>();
        return clone(n, map);
    }

    public static Node clone(Node n, Map<Integer, Node> map) {
        if (n == null) {
            return null;
        }
        if (map.containsKey(n.val)) {
            return map.get(n.val);
        } else {
            Node cloneNode = new Node();
            cloneNode.val = n.val;
            cloneNode.neighbours = new LinkedList<>();
            map.put(n.val, cloneNode);
            for (Node node : n.neighbours) {
                cloneNode.neighbours.add(clone(node, map));
            }
            return cloneNode;
        }
    }
}
