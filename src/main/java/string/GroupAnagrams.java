package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String sorted = String.valueOf(c);

			if (!map.containsKey(sorted)) {
				map.put(sorted, new ArrayList<>());
			}
			map.get(sorted).add(s);
		}

		List<List<String>> l = new ArrayList<>(map.values());
		return l;
	}
}
