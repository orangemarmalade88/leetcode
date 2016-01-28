package design;

import java.util.LinkedHashMap;
import java.util.Map;

/*

 Design and implement a data structure for Least Recently Used (LRU) cache.
 It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present.
 When the cache reached its capacity, it should invalidate the least recently used item
 before inserting a new item.

 */

public class LRUCacheSTL {

	Map<Integer, Integer> map;
	int capacity;

	@SuppressWarnings("serial")
	public LRUCacheSTL(int c) {
		capacity = c;
		// initial capacity, load factor, access order
		map = new LinkedHashMap<Integer, Integer>(c, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(
					Map.Entry<Integer, Integer> eldest) {
				return size() > capacity;
			}
		};
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		return map.get(key);
	}

	public void set(int key, int value) {
		map.put(key, value);
	}
}
