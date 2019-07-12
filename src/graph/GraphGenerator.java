package graph;

public class GraphGenerator {

	public static Graph createGraph(Integer[][] matrix) {
		Graph graph = new Graph();
		for (int i = 0; i < matrix.length; i++) {
			Integer weight = matrix[i][0];
			Integer from = matrix[i][1];
			Integer to = matrix[i][2];
			if (!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			if (!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			Edge newEdge = new Edge(weight, fromNode, toNode);
			fromNode.nexts.add(toNode);
			fromNode.out++;
			toNode.in++;
			fromNode.edges.add(newEdge);
			graph.edges.add(newEdge);
		}
		return graph;
	}

	//邻接矩阵的形式表示图,边的权重全部为整数
	public static Graph createGraph2(Integer[][] matrix) {
		Graph graph = new Graph();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				Integer weight = matrix[i][j];
				Integer from = i;
				Integer to = j;
				if (!graph.nodes.containsKey(from)) {
					graph.nodes.put(from, new Node(from));
				}
				if (!graph.nodes.containsKey(to)) {
					graph.nodes.put(to, new Node(to));
				}
				Node fromNode = graph.nodes.get(from);
				Node toNode = graph.nodes.get(to);
				Edge newEdge = new Edge(weight, fromNode, toNode);
				fromNode.nexts.add(toNode);
				fromNode.out++;
				toNode.in++;
				fromNode.edges.add(newEdge);
				graph.edges.add(newEdge);
			}
		}
		return graph;
	}

}
