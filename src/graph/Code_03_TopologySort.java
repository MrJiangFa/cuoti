package graph;

import java.util.*;

public class Code_03_TopologySort {
    /**
     * directed graph and no loop：有向无环图
     * 寻找入度为 0 的点，删除与该节点的所有edges，即其nexts顶点的入度-1
     *
     * @param graph
     * @return
     */
    public static List<Node> sortedTopology(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }

    /**
     * 总共n门课程，0——n-1，相互之间有先决条件，即必须先修某一门再修另一门，求是否能够修完所有课程，能返回ture，不能返回false
     * 写法简单：但是存在的问题在于需要遍历邻接矩阵找到邻接节点；
     *
     * @param numOfCourses
     * @param prerequisites
     * @return
     */
    private boolean topoSortLeetcode87(int numOfCourses, int[][] prerequisites) {
        int[][] matrix = new int[numOfCourses][numOfCourses];
        int[] indegree = new int[numOfCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            if (matrix[from][to] == 0)
                indegree[to]++;
            matrix[from][to] = 1;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < numOfCourses; i++) {
                if (matrix[course][i] == 1) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numOfCourses;
    }
}
