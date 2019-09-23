package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1. 在无向连通图（图中每一个节点到其他节点都存在一条路径）中求出两个给定节点之间的所有路径；
 * 2. 在所得路径上不能含有环路或重复的点；
 * <p>
 * 思路：
 * 1. 整理节点间关系，为每个节点建立一个集合，集合中保存所有于该节点直接相连的节点；
 * 2. 定义两个点：起始点——终点，求解两点之间所有路径的问题可以分解为：
 * 对于每一个与起始节点直接相连的节点，求解它到终点的所有路径，得到一个路径集合；
 * 3. 采用栈结构保存已经寻到的路径上的节点，路径无法继续向下寻路时，从而实现回溯的过程；
 */
public class Code_07_All_paths_of_two_nodes_in_undirected_graph {

    public static final List<List<Integer>> list = new ArrayList<>();
    public static final LinkedList<Node> stack = new LinkedList<>();

    /**
     * @param curNode：当前起始节点
     * @param preNode：前一个节点
     * @param sourNode：最初起始点
     * @param endNode：终止节点
     * @return
     */
    public static boolean getPaths(Node curNode, Node preNode, Node sourNode, Node endNode) {
        Node node = null;
        //如果符合条件，说明出现环路，不能再顺着该路径继续寻找，返回false;
        if (preNode != null && curNode == preNode)
            return false;
        if (curNode != null) {
            int i = 0;
            stack.push(sourNode);//当前节点入栈
            if (curNode == endNode) {
                savePath();
                return true;
            } else {
                node = curNode.nexts.get(i);
                while (node != null) {
                    //如果node是最初的起始点，或者node就是curNode的上一节点或者node 已经在栈中，
                    // 说明产生环路，应重新在于当前起始节点有连接关系的节点集合中寻找node
                    if (preNode != null && (node == sourNode || node == preNode || stack.contains(node))) {
                        i++;
                        if (i >= curNode.nexts.size())
                            node = null;
                        else
                            node = curNode.nexts.get(i);
                    }
                    //以node为新的起始节点，当前起始节点curNode，递归调用寻路方法
                    if (getPaths(node, curNode, sourNode, endNode))
                        stack.pop();
                    i++;
                    if (i >= curNode.nexts.size())
                        node = null;
                    else
                        node = curNode.nexts.get(i);
                }
                //当遍历完所有与curNode有连接的节点后，说明以curNode 为起始节点到终点的路径已经全部找到；
                stack.pop();
                return false;
            }
        } else
            return false;
    }

    public static void savePath() {
        Object[] arr = stack.toArray();
        List<Integer> tmp = new ArrayList<>();
        for (Object object : arr) {
            tmp.add(((Node) object).value);
        }
        list.add(tmp);
    }
}
