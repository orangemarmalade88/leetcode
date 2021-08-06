package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, Set<Integer>> edge = new HashMap<>();
		for (int[] c : prerequisites) {
			if (!edge.containsKey(c[0]))
				edge.put(c[0], new HashSet<>());
			edge.get(c[0]).add(c[1]);
		}

		boolean[] visited = new boolean[numCourses];
		boolean[] checked = new boolean[numCourses];

		boolean res = false;
		for (int i = 0; i < numCourses; i++) {
			res |= dfs(edge, visited, checked, i, numCourses);
		}

		return !res;
	}

	boolean dfs(Map<Integer, Set<Integer>> edge, boolean[] visited,
			boolean[] checked, int index, int numCourses) {
		if (checked[index])
			return false;

		if (visited[index])
			return true;

		visited[index] = true;

		boolean has_cycle = false;
		if (edge.containsKey(index)) {
			for (int i : edge.get(index)) {
				has_cycle |= dfs(edge, visited, checked, i, numCourses);
			}
		}

		visited[index] = false;

		checked[index] = true;

		return has_cycle;
	}
}
