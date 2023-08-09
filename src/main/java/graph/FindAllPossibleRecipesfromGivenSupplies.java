package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindAllPossibleRecipesfromGivenSupplies {
	public List<String> findAllRecipes(String[] recipes,
			List<List<String>> ingredients, String[] supplies) {
		int n = recipes.length;
		Set<String> set = new HashSet<>();
		for (String s : supplies) {
			set.add(s);
		}

		Map<String, Integer> map = new HashMap<>(); // recipe -> index

		boolean[] visited = new boolean[n];
		boolean[] possible = new boolean[n];

		for (int i = 0; i < n; i++) {
			map.put(recipes[i], i);
		}

		List<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (dfs(map, ingredients, set, visited, possible, i))
				list.add(recipes[i]);
		}
		return list;
	}

	public boolean dfs(Map<String, Integer> map, List<List<String>> ingredients,
			Set<String> supp, boolean[] visited, boolean[] possible,
			int index) {
		visited[index] = true;
		List<String> ingre = ingredients.get(index);
		for (String i : ingre) {
			if (supp.contains(i)) {
				continue;
			}
			int dex = map.getOrDefault(i, -1);
			if (dex == -1)
				return false;
			if (visited[dex] && !possible[dex])
				return false;
			if (!dfs(map, ingredients, supp, visited, possible, dex))
				return false;
		}
		possible[index] = true;
		return true;
	}
}
