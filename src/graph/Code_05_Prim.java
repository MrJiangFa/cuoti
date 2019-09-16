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
     * @param graph
     * @return
     */
    public static Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
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
//    public static void getResult(List<List<Integer>> res,List<Integer> tmpList,int N, int i) {
//        if (i == N) {
//            res.add(new ArrayList<>(tmpList));
//            return;
//        }
//        for (int j = 1; j <= N; j++) {
//            if (!queue.contains(j)) {
//                queue.offer(j);
//                getResult(N, i + 1, queue);
//            }
//        }
//    }

    /**
     *递归思路,求解最短路径问题
     * d(i,V')定义为从顶点i出发经过V'中的各顶点（有且仅有一次），最后回到顶点0的最短路径长度；
     * Cij 定义为顶点i到顶点j的距离
     *
     * 此处 nodes 对应
     *
     * @param matrix
     * @param labelOfNode：出发点的label
     * @param nodes：节点的个数
     * @return
     */
    public static int tSP(int[][] matrix, int labelOfNode, int nodes) {
        if (matrix.length <= 1) {
            return 0;
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
                min = Math.min(min, tSP(matrix, len - i-1, tmp & ((1 << len) - 1 - (1 << i)))
                        + matrix[labelOfNode][len - i-1]);
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2}, {1, 0, 1}, {2, 1, 0}};
        //如果节点的个数为3，111 则表示集合中的元素为{1,2,3}
        System.out.println(tSP(matrix, 0, 3));
//        Queue<Integer> queue = new LinkedList<>();
//        getResult(3,0,queue);
//        res.forEach(a-> System.out.println(a.toString()));
    }
}
