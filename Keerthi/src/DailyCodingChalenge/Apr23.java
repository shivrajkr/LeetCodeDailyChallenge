package DailyCodingChalenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Apr23 {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
		for(int i=0; i<edges.length; i++){
			int[] edge = edges[i];
			ArrayList<Integer> nxt0 = graph.getOrDefault(edge[0], new ArrayList<>());
			ArrayList<Integer> nxt1 = graph.getOrDefault(edge[1], new ArrayList<>());
			nxt0.add(edge[1]);
			nxt1.add(edge[0]);
			graph.put(edge[0], nxt0);
			graph.put(edge[1], nxt1);
		}

		int minHeight = Integer.MAX_VALUE;
		int[] heights = new int[n];
		List<Integer> result = new ArrayList<>();

		for(int i=0; i<n; i++){
			heights[i] = findHeight(graph, new boolean[n], i);
			if(minHeight > heights[i]){
				minHeight = heights[i];
				result = new ArrayList<>(List.of(i));
			} else if(minHeight == heights[i]){
				result.add(i);
			}
		}

		return result;
	}

	public int findHeight(HashMap<Integer, ArrayList<Integer>> graph, boolean[] visited, int idx){
		if(visited[idx]) return 0;
		visited[idx] = true;
		int height = 0;
		for(Integer nxt : graph.getOrDefault(idx, new ArrayList<>())){
			height = Math.max(height, findHeight(graph, visited, nxt)+1);
		}

		return height;
	}
}
