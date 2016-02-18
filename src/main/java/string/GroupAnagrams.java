package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

 Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:
 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]


 Note:

 1.For the return value, each inner list's elements must follow the lexicographic order.
 2.All inputs will be in lower-case.

 */

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		List<List<String>> result = new ArrayList<>();
		for (String s : strs) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String reordered = new String(chars);
			if (map.containsKey(reordered)) {
				map.get(reordered).add(s);
			} else {
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(reordered, list);
			}
		}

		for (List<String> list : map.values()) {
			Collections.sort(list);
			result.add(list);
		}
		return result;
	}
}
