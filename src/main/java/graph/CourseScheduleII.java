package graph;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class CourseScheduleII {
	boolean isPossible = true;

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, Set<Integer>> edges = new HashMap<>();
		for (int[] e : prerequisites) {
			if (!edges.containsKey(e[0]))
				edges.put(e[0], new HashSet<>());
			edges.get(e[0]).add(e[1]);
		}

		boolean[] visited = new boolean[numCourses];
		boolean[] seen = new boolean[numCourses];
		Deque<Integer> queue = new LinkedList<>();

		for (int i = 0; i < numCourses; i++) {
			dfs(edges, visited, seen, i, queue);
		}
		if (isPossible) {
			int[] order = new int[numCourses];
			for (int i = 0; i < numCourses; i++) {
				order[i] = queue.poll();
			}
			return order;
		}
		return new int[0];
	}

	private void dfs(Map<Integer, Set<Integer>> edges, boolean[] visited,
			boolean[] seen, int index, Deque<Integer> queue) {
		if (visited[index])
			return;

		if (seen[index]) {
			isPossible = false;
			return;
		}

		seen[index] = true;
		if (edges.containsKey(index)) {
			for (int i : edges.get(index)) {
				dfs(edges, visited, seen, i, queue);
			}
		}
		seen[index] = false;
		queue.offer(index);
		visited[index] = true;
	}
}
