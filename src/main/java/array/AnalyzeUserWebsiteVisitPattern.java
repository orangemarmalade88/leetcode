package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Pair;

public class AnalyzeUserWebsiteVisitPattern {
	/*
	 * 1152. Analyze User Website Visit Pattern
	 *
	 * We are given some website visits: the user with name username[i] visited
	 * the website website[i] at time timestamp[i].
	 *
	 * A 3-sequence is a list of websites of length 3 sorted in ascending order
	 * by the time of their visits. (The websites in a 3-sequence are not
	 * necessarily distinct.)
	 *
	 * Find the 3-sequence visited by the largest number of users. If there is
	 * more than one solution, return the lexicographically smallest such
	 * 3-sequence.
	 *
	 */
	public List<String> mostVisitedPattern(String[] username, int[] timestamp,
			String[] website) {
		Map<String, List<Pair<Integer, String>>> map = new HashMap<>();
		for (int i = 0; i < username.length; i++) {
			if (map.containsKey(username[i])) {
				map.get(username[i]).add(
						new Pair<Integer, String>(timestamp[i], website[i]));
			} else {
				List<Pair<Integer, String>> list = new ArrayList<>();
				list.add(new Pair<Integer, String>(timestamp[i], website[i]));
				map.put(username[i], list);
			}
		}
		Map<LinkedList<String>, Set<String>> pattern_user = new HashMap<>();
		for (Map.Entry<String, List<Pair<Integer, String>>> entry : map
				.entrySet()) {
			List<Pair<Integer, String>> list = entry.getValue();
			Collections.sort(list,
					(p1, p2) -> p1.getKey().compareTo(p2.getKey()));
			LinkedList<String> pattern = new LinkedList<>();
			for (Pair<Integer, String> p : list) {
				pattern.addLast(p.getValue());
				if (pattern.size() > 3) {
					pattern.remove();
				}
				if (pattern.size() == 3) {
					if (pattern_user.containsKey(pattern)) {
						pattern_user.get(pattern).add(entry.getKey());
					} else {
						Set<String> set = new HashSet<>();
						set.add(entry.getKey());
						pattern_user.put(pattern, set);
					}
				}
			}
		}
		int max = 0;
		List<String> result = null;
		for (Map.Entry<LinkedList<String>, Set<String>> entry : pattern_user
				.entrySet()) {
			if (entry.getValue().size() > max) {
				max = entry.getValue().size();
				result = entry.getKey();
			} else if (entry.getValue().size() == max) {
				if (entry.getKey().get(0).compareTo(result.get(0)) < 0
						|| (entry.getKey().get(0).compareTo(result.get(0)) == 0
								&& entry.getKey().get(1)
										.compareTo(result.get(1)) < 0)
						|| (entry.getKey().get(0).compareTo(result.get(0)) == 0
								&& entry.getKey().get(1)
										.compareTo(result.get(1)) == 0
								&& entry.getKey().get(2)
										.compareTo(result.get(2)) < 0)) {
					result = entry.getKey();
				}
			}
		}
		return result;
	}
}
