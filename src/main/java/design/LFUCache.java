package design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache {
	Map<Integer, Integer> values = new HashMap<>();
	Map<Integer, Integer> counts = new HashMap<>();
	TreeMap<Integer, List<Integer>> freqs = new TreeMap<>();
	int capacity;

	public LFUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!values.containsKey(key))
			return -1;
		int value = values.get(key);
		int count = counts.get(key);
		counts.put(key, count + 1);
		List<Integer> list = freqs.get(count);
		list.remove(Integer.valueOf(key));
		if (list.size() == 0)
			freqs.remove(count);
		if (!freqs.containsKey(count + 1))
			freqs.put(count + 1, new LinkedList<>());
		freqs.get(count + 1).add(key);
		return value;
	}

	public void put(int key, int value) {
		if (capacity == 0)
			return;
		if (values.size() == capacity && !values.containsKey(key)) {
			int c = freqs.firstEntry().getKey();
			List<Integer> list = freqs.firstEntry().getValue();
			int keyToRemove = list.get(0);
			list.remove(0);
			if (list.size() == 0)
				freqs.remove(c);
			counts.remove(keyToRemove);
			values.remove(keyToRemove);
		}
		int count = counts.getOrDefault(key, 0);
		if (values.containsKey(key)) {
			List<Integer> list = freqs.get(count);
			list.remove(Integer.valueOf(key));
			if (list.size() == 0)
				freqs.remove(count);
		}
		counts.put(key, count + 1);
		if (!freqs.containsKey(count + 1))
			freqs.put(count + 1, new LinkedList<>());
		freqs.get(count + 1).add(key);
		values.put(key, value);
	}

	public static void main(String[] args) {
		LFUCache lru = new LFUCache(2);
		lru.put(1, 1);
		lru.put(2, 2);
		lru.get(1);

		lru.put(3, 3);
		lru.get(2);
		lru.get(3);

		lru.put(4, 4);

		lru.get(1);
		lru.get(3);
		lru.get(4);

		System.out.println(lru.get(1));
	}
}
