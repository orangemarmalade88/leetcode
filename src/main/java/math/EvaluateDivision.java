package math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

	double result = -1.0;

	public double[] calcEquation(List<List<String>> equations, double[] values,
			List<List<String>> queries) {

		Map<String, Map<String, Double>> map = new HashMap<>();

		for (int i = 0; i < equations.size(); i++) {
			String a = equations.get(i).get(0);
			String b = equations.get(i).get(1);
			double val = values[i];

			if (!map.containsKey(a)) {
				map.put(a, new HashMap<>());
			}
			map.get(a).put(b, val);
			if (!map.containsKey(b)) {
				map.put(b, new HashMap<>());
			}
			map.get(b).put(a, 1.0 / val);
		}

		double[] results = new double[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			result = -1.0;
			Set<String> visited = new HashSet<>();
			visited.add(queries.get(i).get(0));
			if (map.containsKey(queries.get(i).get(0))) {
				dfs(map, visited, queries.get(i).get(0), queries.get(i).get(1),
						1.0);
			}
			results[i] = result;
		}
		return results;
	}

	public void dfs(Map<String, Map<String, Double>> map, Set<String> visited,
			String source, String des, double prod) {
		if (source.equals(des)) {
			result = prod;
			return;
		}
		Map<String, Double> route = map.get(source);
		if (route != null) {
			for (Map.Entry<String, Double> e : route.entrySet()) {
				if (!visited.contains(e.getKey())) {
					visited.add(e.getKey());
					dfs(map, visited, e.getKey(), des, prod * e.getValue());
				}
			}
		}
	}
}
