package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseScheduleIV {
	int n;
	Map<Integer, Set<Integer>> map = new HashMap<>();
	int[][] pre;

	public List<Boolean> checkIfPrerequisite(int numCourses,
			int[][] prerequisites, int[][] queries) {
		for (int[] p : prerequisites) {
			if (!map.containsKey(p[0]))
				map.put(p[0], new HashSet<>());
			map.get(p[0]).add(p[1]);
		}
		n = numCourses;
		pre = new int[n][n];
		List<Boolean> ans = new ArrayList<>();
		for (int[] q : queries) {
			ans.add(isP(q[0], q[1]));
		}
		return ans;
	}

	public boolean isP(int a, int b) {
		if (pre[a][b] != 0) {
			if (pre[a][b] == 1)
				return true;
			return false;
		}

		if (!map.containsKey(a)) {
			pre[a][b] = 2;
			return false;
		}

		if (map.get(a).contains(b)) {
			pre[a][b] = 1;
			return true;
		}

		for (int c : map.get(a)) {
			if (isP(c, b)) {
				pre[a][b] = 1;
				return true;
			}
		}
		pre[a][b] = 2;
		return false;
	}

	public List<Boolean> checkIfPrerequisite2(int numCourses,
			int[][] prerequisites, int[][] queries) {
		boolean[][] connected = new boolean[numCourses][numCourses];
		for (int[] p : prerequisites) {
			connected[p[0]][p[1]] = true;
		}
		for (int k = 0; k < numCourses; k++) {
			for (int i = 0; i < numCourses; i++) {
				for (int j = 0; j < numCourses; j++) {
					connected[i][j] |= connected[i][k] && connected[k][j];
				}
			}
		}
		List<Boolean> ans = new ArrayList<>();
		for (int[] q : queries) {
			ans.add(connected[q[0]][q[1]]);
		}
		return ans;
	}
}
