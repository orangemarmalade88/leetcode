package string;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	public List<Integer> partitionLabels(String s) {
		int[] end = new int[26];

		for (int i = 0; i < s.length(); i++) {
			int id = s.charAt(i) - 'a';
			end[id] = i;
		}

		List<Integer> result = new ArrayList<>();

		int head = 0;
		int tail = 0;
		for (int i = 0; i < s.length(); i++) {
			int id = s.charAt(i) - 'a';
			tail = Math.max(tail, end[id]);
			if (tail == i) {
				result.add(tail - head + 1);
				head = i + 1;
			}
		}

		return result;
	}
}
