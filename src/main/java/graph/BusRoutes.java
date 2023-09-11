package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {
	public int numBusesToDestination(int[][] routes, int source, int target) {
		Map<Integer, Set<Integer>> stopMap = new HashMap<>();
		// stop -> buses

		for (int i = 0; i < routes.length; i++) {
			for (int j : routes[i]) {
				if (!stopMap.containsKey(j)) {
					stopMap.put(j, new HashSet<>());
				}
				stopMap.get(j).add(i);
			}
		}

		Queue<Integer> q = new LinkedList<>();
		q.offer(source);
		Set<Integer> visited = new HashSet<>(); // visited stops
		visited.add(source);

		Set<Integer> bus_visited = new HashSet<>();

		int steps = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int cur = q.poll();
				if (cur == target)
					return steps;
				Set<Integer> set = stopMap.get(cur);
				if (set != null) {
					for (int bus : set) {
						if (!bus_visited.contains(bus)) {
							bus_visited.add(bus);
							for (int stop : routes[bus]) {
								if (!visited.contains(stop)) {
									q.offer(stop);
									visited.add(stop);
								}
							}
						}
					}
				}
			}
			steps++;
		}
		return -1;
	}
}
