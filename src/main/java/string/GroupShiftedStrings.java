package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

 Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd".
 We can keep "shifting" which forms the sequence:
 "abc" -> "bcd" -> ... -> "xyz"

 Given a list of strings which contains only lowercase alphabets, group all strings that belong to the
 same shifting sequence.

 For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 Return:
 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]

 Note: For the return value, each inner list's elements must follow the lexicographic order.

 */

public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
		Map<List<Integer>, List<String>> map = new HashMap<>();
		for (String s : strings) {
			List<Integer> code = new ArrayList<>();
			if (s.length() >= 1)
				code.add(0);
			for (int i = 1; i < s.length(); i++) {
				int dis = s.charAt(i) - s.charAt(i - 1);
				if (dis < 0)
					dis += 26;
				code.add(dis);
			}
			if (map.containsKey(code)) {
				map.get(code).add(s);
			} else {
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(code, list);
			}
		}
		List<List<String>> result = new ArrayList<>(map.values());
		for (List<String> list : result) {
			Collections.sort(list);
		}

		return result;
	}
}
