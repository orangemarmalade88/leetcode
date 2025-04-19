package string;

import java.util.HashMap;
import java.util.Map;

public class CountCommonWordsWithOneOccurrence {
	public int countWords(String[] words1, String[] words2) {
		Map<String, Integer> count1 = new HashMap<>();
		Map<String, Integer> count2 = new HashMap<>();
		for (String s : words1) {
			count1.put(s, count1.getOrDefault(s, 0) + 1);
		}
		for (String s : words2) {
			count2.put(s, count2.getOrDefault(s, 0) + 1);
		}
		int count = 0;
		for (Map.Entry<String, Integer> e : count1.entrySet()) {
			if (e.getValue() == 1 && count2.getOrDefault(e.getKey(), 0) == 1) {
				count++;
			}
		}
		return count;
	}
}
