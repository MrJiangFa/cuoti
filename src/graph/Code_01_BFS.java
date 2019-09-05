package graph;

import java.util.*;

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
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);//对所有节点的标记进行输出
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }


    //起点和终点问题，startWord = "hit"  endWord = "cog"  dict = ["hot","dot","dog","lot","log"]
    //所有单词具有相同的长度，所有单词只由小写字母组成，字典中不存在重复的单词，
    // 每次只能变换一个字符，请问从起点单词是否可以到达终点单词，最短多少步，如果不存在则返回0？
    //"hit"->"hot"->"dot"->"dog"->"cog"
    //此题可以采用双向BFS

    //基本思路：字典中与 hit 相差一个字符的单词可以视为 hit 在图中的相邻节点
    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        set.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.equals(endWord)) {
                return step;
            }
            wordList.remove(cur);
            for (int i = 0; i < cur.length(); i++) {
                char[] curChars = cur.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    curChars[i] = c;
                    String newWord = new String(curChars);
                    if (wordList.contains(newWord) && !set.contains(newWord)) {
                        set.add(newWord);
                        queue.add(newWord);
                        wordList.remove(newWord);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    //迷宫问题
}
