package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> result_set = new HashSet<>();
		List<String> result = new ArrayList<>();
		if (s.length() < 10)
			return result;
		StringBuilder sb = new StringBuilder(s.substring(0, 10));
		Set<String> set = new HashSet<>();
		set.add(sb.toString());
		for (int i = 10; i < s.length(); i++) {
			sb.deleteCharAt(0);
			sb.append(s.charAt(i));
			String cur = sb.toString();
			if (set.contains(cur)) {
				result_set.add(cur);
			} else {
				set.add(cur);
			}
		}
		result.addAll(result_set);
		return result;
	}
}
