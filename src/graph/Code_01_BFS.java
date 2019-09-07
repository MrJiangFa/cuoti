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
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String cur = q.poll();
                for (int i = 0; i < beginWord.length(); i++) {
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        StringBuilder newWord = new StringBuilder(cur);
                        newWord.setCharAt(i, letter);
                        if (set.contains(newWord.toString())) {
                            if (newWord.toString().equals(endWord))
                                return step + 1;
                            set.remove(newWord.toString());
                            q.offer(newWord.toString());
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }

    //双向bfs
    private static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        int len = 1;
        HashSet<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            //如果 beginSet 中元素个数多于 endSet 中的元素个数，则进行交换
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> tmp = new HashSet<>();
            for (String word : beginSet) {
                for (int i = 0; i < word.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(i, c);
                        if (endSet.contains(sb.toString())) {
                            return len + 1;
                        }
                        if (!visited.contains(sb.toString()) && wordList.contains(sb.toString())) {
                            tmp.add(sb.toString());
                            visited.add(sb.toString());
                        }
                    }
                }
            }
            beginSet = tmp;
            len++;
        }
        return 0;
    }

    //迷宫问题
}
