package graph;

import java.util.*;

//只是适用于无向图
//cut+cross

/**
 * 证明：反证法
 * 假设还剩最后一个节点可选，剩余的割中只能选择最小割，即最小的边
 * prim+heap的时间复杂度为 vloge --> 采用邻接矩阵法表示
 */
public class Code_05_Prim {

    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }

    }

    /**
     *
     * @param graph
     * @return
     */
    public static Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(
                new EdgeComparator());
        HashSet<Node> set = new HashSet<>();
        Set<Edge> result = new HashSet<>();
        for (Node node : graph.nodes.values()) {
            if (!set.contains(node)) {
                set.add(node);
                priorityQueue.addAll(node.edges);
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        result.add(edge);
                        priorityQueue.addAll(toNode.edges);
                    }
                }
            }
        }
        return result;
    }

    public static class MyComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge a, Edge b) {
            return a.weight - b.weight;
        }
    }

    //前一状态给我的edges
    //pirm算法的递归版本
    //前一状态给当前状态的是已经入选的边，base case为所有的边都有的时候
    public static Set<Edge> prim2(Graph graph, HashSet<Edge> edges, HashSet<Node> nodes) {
        if (edges.size() == (graph.nodes.size() - 1)) {
            return edges;
        } else {
            PriorityQueue<Edge> pe = new PriorityQueue<>(new MyComparator());
            for (Node node : nodes) {
                for (Edge edge : node.edges) {
                    if (!nodes.contains(edge.to)) {
                        pe.offer(edge);
                    }
                }
            }
            nodes.add(pe.peek().to);
            edges.add(pe.poll());
            prim2(graph, edges, nodes);
            return edges;
        }
    }

    /**
     * 排列组合求解TSP（Traveling Salesman Problem,旅行商问题)问题，暴力法，没有什么物理意义，难以表示成dp形式
     * 旅行商问题：从一点出发，经过几座城市，又回到出发点，求怎么走路径最短
     */
    static Queue<Queue<Integer>> res = new LinkedList<>();

    public static void getResult(int[] nodes, int i, Queue<Integer> queue) {
        if (i == nodes.length) {
            res.add(queue);
            return;
        }
        for (int j = 1; j <= nodes.length; j++) {
            if (!queue.contains(j)) {
                queue.offer(j);
                getResult(nodes, i + 1, queue);
            }
        }
    }

    //递归思路,求解最短路径问题
    public static int tSP(int[][] matrix, int labelOfNode, int nodes) {
        if (matrix.length <= 1) {
            return 0;
        }
        if (matrix.length == 2) {
            return 2 * matrix[0][1];
        }
        if (nodes == 0) {
            return matrix[labelOfNode][0];
        }
        int min = Integer.MAX_VALUE;
        int len = matrix.length - 1;
        //除出发点外，有几个点就生成多大的数组
        for (int i = 0; i < len; i++) {
            int tmp = nodes;
            if ((1 & (nodes >> i)) == 1) {
                min = Math.min(min, tSP(matrix, len - i, tmp & ((1 << len) - 1 - (1 << i)))
                        + matrix[labelOfNode][len - i]);
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2}, {1, 0, 1}, {2, 1, 0}};
        System.out.println(tSP(matrix, 0, 3));
    }
}
