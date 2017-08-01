class UndirectedGraphNode {
	int label;
	List<UndirectedGraph> neighbors;
	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}

public class DeepCopy {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)	return null;
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		dfs(map, node);
		return map.get(node); 
	}
	
	private void dfs(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
		if (map.containsKey(node))	return;
		UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
		map.put(node, copyNode);
		
		for (UndirectedGraphNode neighbor : node.neighbors) {
			dfs(map, neighbor);
			copyNode.neighbors.add(map.get(neighbor));
		}
	}
}

