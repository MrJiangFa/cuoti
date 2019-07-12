package graph_undirected;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class DFSAndBFS {
    //两种遍历图的方式
    public static class Node {
        char label;
        LinkedList<Node> nexts;

        Node(char label) {
            this.label = label;
            this.nexts = new LinkedList<>();
        }
    }

    public static HashMap<Character, Node> generateGraph() {
        HashMap<Character, Node> graph = new HashMap<>();
        Node u = new Node('u');
        Node v = new Node('v');
        Node w = new Node('w');
        Node x = new Node('x');
        Node y = new Node('y');
        Node z = new Node('z');
        u.nexts.add(x);
        u.nexts.add(v);
        v.nexts.add(y);
        w.nexts.add(y);
        w.nexts.add(z);
        x.nexts.add(v);
        y.nexts.add(x);
        z.nexts.add(z);
        graph.put('u',u);
        graph.put('v',v);
        graph.put('w',w);
        graph.put('x',x);
        graph.put('y',y);
        graph.put('z',z);
        return graph;
    }

    //记录进入每个节点和离开每个节点的时间
    static int count =0;
    public static void visit(HashMap<Character,Node> graph, HashSet<Character> visited, char start){
        if(!visited.contains(start)){
            visited.add(start);
            for(Node node : graph.get(start).nexts){
                if(!visited.contains(node)){
                    visit(graph,visited,node.label);
                }
            }
        }
    }
    //非递归实现dfs
    public static void dfs(Node start){
        if(start==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(start);
        set.add(start);
        System.out.print(start.label+" ");
        while(!stack.isEmpty()){
            Node tmp = stack.pop();
            for(Node node : tmp.nexts){
                if(!set.contains(node)){
                    stack.push(tmp);
                    stack.push(node);
                    set.add(node);
                    System.out.print(node.label+" ");
                    break;
                }
            }
        }
    }

    //给定一个字符串s，将s划分为若干子串，使得每一个子串都是回文串，计算所有可能的划分
    //计算所有回文串

    public static void main(String[] args){
        HashMap<Character,Node> graph = generateGraph();
        HashSet<Character> visited = new HashSet<>();
        visit(graph,visited,'u');
        dfs(graph.get('u'));
    }
}
