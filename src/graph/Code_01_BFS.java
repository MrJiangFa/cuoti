package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Code_01_BFS {
    //广度优先搜索，应用于迷宫问题
    //思想：从起始点开始，将其所有邻接的点加到队列中，标记顶点距离起始点的距离，并将其标记为已访问；
    //从顶点中取出最先进入队列的节点，取出其周围邻接点，加到队列末尾；
    //直到队列为空
    //遍历连通图中所有顶点和边，时间复杂度为O(V+E);
    //扩展：双向BFS
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> map = new HashSet<>();
        queue.add(node);
        map.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!map.contains(next)) {
                    map.add(next);
                    queue.add(next);
                }
            }
        }
    }
    //起点和终点问题，start = "hit"  end = "cog"  dict = ["hot","dot","dog","lot","log"]
    //每次只能变换一个字符，请问从起点单词是否可以到达终点单词，最短多少步？
    //"hit"->"hot"->"dot"->"dog"->"cog"


    //迷宫问题
}
