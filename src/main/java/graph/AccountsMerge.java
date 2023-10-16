package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge {
	public static List<List<String>> accountsMerge(
			List<List<String>> accounts) {

		Set<String> visited = new HashSet<>();
		Map<String, String> nodes = new HashMap<>(); // email -> name
		List<List<String>> result = new ArrayList<>();

		Map<String, Set<String>> graph = new HashMap<>(); // email -> others
															// emails

		for (List<String> s : accounts) {
			String name = s.get(0);
			List<String> emails = s.subList(1, s.size());
			for (String e : emails) {
				nodes.put(e, name);
			}
			Set<String> neighbors = new HashSet<>(emails);
			for (String n : neighbors) {
				Set<String> next = graph.getOrDefault(n, new HashSet<>());
				next.addAll(neighbors);
				graph.put(n, next);
			}
		}

		for (String s : nodes.keySet()) {
			List<String> re = new ArrayList<>();
			if (!visited.contains(s)) {
				dfs(s, nodes, visited, graph, re);
				Collections.sort(re);
				re.add(0, nodes.get(s));
				result.add(re);
			}
		}
		return result;
	}

	public static void dfs(String email, Map<String, String> nodes,
			Set<String> visited, Map<String, Set<String>> graph,
			List<String> re) {
		re.add(email);
		visited.add(email);
		Set<String> neighbors = graph.get(email);
		for (String n : neighbors) {
			if (!visited.contains(n))
				dfs(n, nodes, visited, graph, re);
		}
	}

	public static void main(String[] args) {
		List<List<String>> input = Arrays.asList(
				Arrays.asList("John", "johnsmith@mail.com",
						"john_newyork@mail.com"),
				Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
				Arrays.asList("Mary", "mary@mail.com"),
				Arrays.asList("John", "johnnybravo@mail.com"));
		accountsMerge(input);
	}
}
