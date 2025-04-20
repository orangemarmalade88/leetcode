package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReconstructItinerary {

	List<String> final_result = null;
	String result_path = "";
	int n = -1;

	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, Set<String>> map = new HashMap<>();
		Map<String, Set<String>> visited = new HashMap<>();
		n = tickets.size();
		for (List<String> s : tickets) {

			map.computeIfAbsent(s.get(0), value -> new HashSet<>());
			map.get(s.get(0)).add(s.get(1));

			visited.computeIfAbsent(s.get(0), value -> new HashSet<>());
		}
		List<String> result = new ArrayList<>();
		dfs(map, visited, "JFK", result, "JFK");
		return final_result;
	}

	public void dfs(Map<String, Set<String>> map,
			Map<String, Set<String>> visited, String cur, List<String> result,
			String path) {
		if (result.size() == n + 1) {
			if (final_result == null || result_path.compareTo(path) > 0) {
				result_path = path;
				final_result = result;
			}
		} else {
			Set<String> des = map.get(cur);
			Set<String> vis = visited.get(cur);
			if (des != null) {
				for (String d : des) {
					List<String> next = new ArrayList<>(result);
					next.add(d);
					if (!vis.contains(d)) {
						vis.add(d);
						dfs(map, visited, d, next, path + d);
					}
				}
			}
		}
	}
}
