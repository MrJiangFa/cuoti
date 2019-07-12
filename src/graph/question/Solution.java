package graph.question;

import java.util.*;

class Solution {
    class Node{
        int value;
        int in;
        int out;
        ArrayList<Node> nexts;
        ArrayList<Edge> edges;
        Node(int value){
            this.value = value;
            this.in = 0;
            this.out = 0;
            this.nexts = new ArrayList<Node>();
            this.edges = new ArrayList<Edge>();
        }
    }
    class Edge{
        Node from;
        Node to;
        Edge(Node from,Node to){
            this.from = from;
            this.to = to;
        }
    }
    class Graph{
        HashMap<Integer,Node> nodes;
        HashSet<Edge> edges;
        Graph(){
            this.edges = new HashSet<>();
            this.nodes = new HashMap<>();
        }
    }
    public Graph generateGraph(int[][] prerequisites){
        Graph graph = new Graph();
        for(int i = 0;i<prerequisites.length;i++){
            Integer from = prerequisites[i][0];
            Integer to = prerequisites[i][1];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode  = graph.nodes.get(to);
            Edge newEdge = new Edge(fromNode,toNode);
            graph.edges.add(newEdge);
            fromNode.nexts.add(toNode);
            fromNode.edges.add(newEdge);
            fromNode.out++;
            toNode.in++;
        }
        return graph;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null||prerequisites.length==0){
            return true;
        }
        Graph graph = generateGraph(prerequisites);
        HashMap<Node,Integer> inMap = new HashMap<>();//用于存放每个节点的入度
        Queue<Node> zeroInQueue = new LinkedList<>();
        for(Node node : graph.nodes.values()){
            inMap.put(node,node.in);
            if(node.in==0){
                zeroInQueue.add(node);
            }
        }
        List<Node> res = new ArrayList<>();
        while(!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            res.add(cur);
            for(Node next : cur.nexts){
                inMap.put(next,inMap.get(next)-1);
                if(inMap.get(next)==0){
                    zeroInQueue.add(next);
                }
            }
        }
        if(res.size()==graph.nodes.size()){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Solution s = new Solution();

    }
}