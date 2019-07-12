package graph;

import java.util.HashSet;
import java.util.Stack;

public class Code_02_DFS {
	//从起始点开始，递归访问其所有邻接节点，
	//非递归版本

	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					break;
				}
			}
		}
	}
}
