package design;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache2 {
	// Can also define a doubly linked list and store Node in hashmap
	// Implement delete in O(1)
	Map<Integer, Integer> map = new HashMap<>();
	Map<Integer, Integer> count = new HashMap<>();
	Deque<Integer> deque = new LinkedList<>();
	int capacity;

	public LRUCache2(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		count.put(key, count.getOrDefault(key, 0) + 1);
		deque.addLast(key);
		return map.get(key);
	}

	public void put(int key, int value) {
		if (map.size() == capacity && !map.containsKey(key)) {
			int c = 0;
			do {
				int first = deque.getFirst();
				c = count.get(first) - 1;
				if (c == 0)
					map.remove(first);
				count.put(first, c);
				deque.removeFirst();
			} while (c > 0);
		}
		deque.addLast(key);
		count.put(key, count.getOrDefault(key, 0) + 1);
		map.put(key, value);
	}
}

class LRUCache extends LinkedHashMap<Integer, Integer> {
	private static final long serialVersionUID = 1L;
	private final int capacity;

	public LRUCache(int capacity) {
		super(capacity, 0.75F, false);
		this.capacity = capacity;
	}

	public int get(int key) {
		return super.getOrDefault(key, -1);
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(2);
		lru.put(1, 1);
		lru.put(2, 2);
		lru.get(2);
		lru.get(1);
		lru.put(3, 3);
		System.out.println(lru.get(1));

	}
}