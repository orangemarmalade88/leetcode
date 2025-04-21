package graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {

	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		for (List<String> s : tickets) {
			map.computeIfAbsent(s.get(0), value -> new PriorityQueue<>())
					.add(s.get(1));
		}
		List<String> final_result = new LinkedList<>();

		dfs(map, "JFK", final_result);
		Collections.reverse(final_result);
		return final_result;
	}

	public void dfs(Map<String, PriorityQueue<String>> map, String cur,
			List<String> final_result) {
		PriorityQueue<String> pq = map.get(cur);
		while (pq != null && !pq.isEmpty()) {
			String des = pq.poll();
			dfs(map, des, final_result);
		}
		final_result.add(cur);
	}
}
