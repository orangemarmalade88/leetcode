package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

	public List<Integer> topKFrequent2(int[] nums, int k) {
		return null;
	}

	public List<Integer> topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		Comparator<Map.Entry<Integer, Integer>> comp = new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1,
					Entry<Integer, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}

		};
		Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(comp);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (pq.size() < k) {
				pq.offer(entry);
			} else {
				if (comp.compare(pq.peek(), entry) < 0) {
					pq.poll();
					pq.offer(entry);
				}
			}
		}

		List<Integer> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : pq) {
			list.add(entry.getKey());
		}

		return list;
	}
}
