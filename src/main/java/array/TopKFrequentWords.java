package array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (String s : words) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		Queue<Map.Entry<String, Integer>> q = new PriorityQueue<>(
				(a, b) -> a.getValue() != b.getValue()
						? a.getValue() - b.getValue()
						: b.getKey().compareTo(a.getKey()));
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			q.offer(e);
			if (q.size() > k)
				q.poll();
		}
		List<String> res = new LinkedList<>();
		while (!q.isEmpty()) {
			res.add(0, q.poll().getKey());
		}
		return res;
	}
}
