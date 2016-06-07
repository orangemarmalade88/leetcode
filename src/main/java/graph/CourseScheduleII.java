package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] degrees = new int[numCourses];
		int[] order = new int[numCourses];
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			map.put(i, new HashSet<Integer>());
		}

		for (int[] pre : prerequisites) {
			if (!map.get(pre[1]).contains(pre[0])) {
				map.get(pre[1]).add(pre[0]);
				degrees[pre[0]]++;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (degrees[i] == 0)
				queue.offer(i);
		}
		int count = 0;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			order[count] = current;
			count++;
			Set<Integer> children = map.get(current);
			for (int i : children) {
				if (--degrees[i] == 0) {
					queue.offer(i);
				}
			}
		}
		if (count == numCourses)
			return order;
		else
			return new int[numCourses];
	}
}
