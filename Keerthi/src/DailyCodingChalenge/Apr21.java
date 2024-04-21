package DailyCodingChalenge;

import java.util.ArrayList;
import java.util.HashMap;

class Apr21 {
	public boolean validPath(int n, int[][] edges, int source, int destination) {
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
		for(int i=0; i<n; i++){
			graph.put(i, new ArrayList<>());
		}

		for(int[] edge : edges){
			int v1 = edge[0];
			int v2 = edge[1];
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		boolean[] visited = new boolean[n];
		return validPath(source, destination, visited, graph);
	}

	public boolean validPath(int source, int destination, boolean[] visited, HashMap<Integer, ArrayList<Integer>> graph){
		if(visited[source]) return false;
		visited[source] = true;
		if(source == destination) return true;
		for(Integer nxt : graph.get(source))
			if(validPath(nxt, destination, visited, graph)) return true;
		return false;
	}
}
