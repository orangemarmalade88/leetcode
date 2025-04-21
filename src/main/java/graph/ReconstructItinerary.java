package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {

	List<String> final_result = new LinkedList<>();

	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		for (List<String> s : tickets) {
			map.computeIfAbsent(s.get(0), value -> new PriorityQueue<>())
					.add(s.get(1));
		}
		dfs(map, "JFK");
		return final_result;
	}

	public void dfs(Map<String, PriorityQueue<String>> map, String cur) {
		PriorityQueue<String> pq = map.get(cur);
		while (pq != null && !pq.isEmpty()) {
			String des = pq.poll();
			dfs(map, des);
		}
		final_result.add(0, cur);
	}
}
