package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

// no negative weight

/**
 * https://www.jianshu.com/p/ff6db00ad866
 * 如果计算节点A到其他节点的最短路径
 * 1. 引入两个集合(S,U)
 * 2. S集合包-含已经求出最短路径的点（及最短路径长度，初始时A>A=0），U集合包含未求出最短路径的点
 * 3. 对U集合中
 */
public class Code_06_Dijkstra {
    public static void main(String[] args) {
        int[][] arr = new int[7][7];
        arr[0][2] = 1;
        arr[1][5] = 1;
        arr[2][3] = 1;
        arr[3][2] = 1;
        arr[4][3] = 1;
        arr[5][4] = 1;
        arr[6][5] = 1;
        System.out.println(get(7, 1, 1, 1, arr, 2));
    }

    private static int get(int N, int A, int B, int C, int[][] arr, int i) {
        if (i == 0) {
            return 0;
        }
        if (i == N - 1) {
            int res = Integer.MAX_VALUE;
            for (int row = 0; row < N - 1; row++) {
                if (arr[row][N - 1] == 1) {
                    int before = get(N, A, B, C, arr, row);
                    res = Math.min(res, before + A);
                }
                if (arr[row][N - 2] == 1) {
                    int before = get(N, A, B, C, arr, row);
                    res = Math.min(res, before + C);
                }
            }
            return res;
        }
        int res = Integer.MAX_VALUE;
        for (int row = 0; row < N; row++) {
            if (arr[row][i - 1] == 1) {
                int before = get(N, A, B, C, arr, row);
                res = Math.min(res, before + C);
            }
            if (arr[row][i] == 1) {
                int before = get(N, A, B, C, arr, row);
                res = Math.min(res, before + A);
            }
            if (arr[row][i + 1] == 1) {
                int before = get(N, A, B, C, arr, row);
                res = Math.min(res, before + B);
            }
        }
        return res;
    }

//    public static void main(String[] args) {
//        int max = Integer.MAX_VALUE;
//        Integer[][] matrix = new Integer[][]{{0, 4, max, 2, max}, {4, 0, 4, 1, max}, {max, 4, 0, 1, 3}, {2, 1, 1, 0, 7}, {max, max, 3, 7, 0}};
//        Graph graph = GraphGenerator.createGraph2(matrix);
//        HashMap<Node, Double> map = dijkstraByJF(0, graph);
//        for (Entry<Node, Double> entry : map.entrySet()) {
//            System.out.println("0->" + entry.getKey().value + "的最短路径长度为：" + entry.getValue());
//        }
//    }

    /**
     * 此方法经过验证为正确方法
     * 时间复杂度为O(VE)
     *
     * @param source:表示源节点的数字
     * @param graph:图
     * @return
     */
    public static HashMap<Node, Double> dijkstraByJF(int source, Graph graph) {
        HashMap<Node, Double> distanceMap = new HashMap<>();//key:desNode (Node(source)->desNode) value:distance {Node(source)->desNode}
        HashSet<Node> leftNodes = new HashSet<>();//剩余还未计算距离Node(source)的最短路径
        //初始化distanceMap，除源节点外，所有节点
        for (Node node : graph.nodes.values()) {
            if (node.value == source) {
                distanceMap.put(node, 0d);
            } else {
                distanceMap.put(node, Double.POSITIVE_INFINITY);
            }
            leftNodes.add(node);
        }

        while (!leftNodes.isEmpty()) {
            Node minNode = null;
            double miniDistance = Double.POSITIVE_INFINITY;
            for (Node node : leftNodes) {
                if (miniDistance > distanceMap.get(node)) {
                    miniDistance = distanceMap.get(node);
                    minNode = node;
                }
            }
            leftNodes.remove(minNode);
            for (Edge edge : minNode.edges) {
                Double newDistance = distanceMap.get(minNode) + edge.weight;
                if (distanceMap.get(edge.to) > newDistance) {
                    distanceMap.put(edge.to, newDistance);
                }
            }

        }
        return distanceMap;
    }

    public static HashMap<Node, Integer> dijkstra1(Node head) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();//存储的head到其他节点的当前最短路径
        distanceMap.put(head, 0);//head->head = 0
        HashSet<Node> selectedNodes = new HashSet<>();

        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                }
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap,
                                                       HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

    public static class NodeRecord {
        public Node node;
        public int distance;

        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static class NodeHeap {
        private Node[] nodes;
        private HashMap<Node, Integer> heapIndexMap;
        private HashMap<Node, Integer> distanceMap;
        private int size;

        public NodeHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void addOrUpdateOrIgnore(Node node, int distance) {
            if (inHeap(node)) {
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                insertHeapify(node, heapIndexMap.get(node));
            }
            if (!isEntered(node)) {
                nodes[size] = node;
                heapIndexMap.put(node, size);
                distanceMap.put(node, distance);
                insertHeapify(node, size++);
            }
        }

        public NodeRecord pop() {
            NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            swap(0, size - 1);
            heapIndexMap.put(nodes[size - 1], -1);
            distanceMap.remove(nodes[size - 1]);
            nodes[size - 1] = null;
            heapify(0, --size);
            return nodeRecord;
        }

        private void insertHeapify(Node node, int index) {
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void heapify(int index, int size) {
            int left = index * 2 + 1;
            while (left < size) {
                int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left])
                        ? left + 1 : left;
                smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
                if (smallest == index) {
                    break;
                }
                swap(smallest, index);
                index = smallest;
                left = index * 2 + 1;
            }
        }

        private boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }

        private boolean inHeap(Node node) {
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }

        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);
            Node tmp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = tmp;
        }
    }

    public static HashMap<Node, Integer> dijkstra2(Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head, 0);
        HashMap<Node, Integer> result = new HashMap<>();
        while (!nodeHeap.isEmpty()) {
            NodeRecord record = nodeHeap.pop();
            Node cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
            result.put(cur, distance);
        }
        return result;
    }

}
