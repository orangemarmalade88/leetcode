package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PossibleBipartition {
	public boolean possibleBipartition(int n, int[][] dislikes) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();

		for (int[] dis : dislikes) {
			int a = dis[0];
			int b = dis[1];
			graph.computeIfAbsent(a, k -> new HashSet<>()).add(b);
			graph.computeIfAbsent(b, k -> new HashSet<>()).add(a);
		}

		Set<Integer> g1 = new HashSet<>();
		Set<Integer> g2 = new HashSet<>();

		for (int i = 0; i < n; i++) {
			boolean possible1 = dfs(i, true, g1, g2, graph);
			if (possible1) {
				g1.remove(i);
			}
			boolean possible2 = dfs(i, false, g1, g2, graph);
			if (possible1) {
				g2.remove(i);
			}
			if (!possible1 && !possible2)
				return false;
		}
		return true;
	}

	public boolean dfs(int i, boolean set1, Set<Integer> g1, Set<Integer> g2,
			Map<Integer, Set<Integer>> graph) {
		for (int g1m : g1) {
			if (graph.get(i).contains(g1m))
				return false;
			g1.add(i);
		}
		return true;
	}
}
