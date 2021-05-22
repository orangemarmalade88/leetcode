package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

	/*
	 * Create a timebased key-value store class TimeMap, that supports two
	 * operations.
	 *
	 * 1. set(string key, string value, int timestamp)
	 *
	 * Stores the key and value, along with the given timestamp. 2. get(string
	 * key, int timestamp)
	 *
	 * Returns a value such that set(key, value, timestamp_prev) was called
	 * previously, with timestamp_prev <= timestamp. If there are multiple such
	 * values, it returns the one with the largest timestamp_prev. If there are
	 * no values, it returns the empty string ("").
	 *
	 */
	private final Map<String, TreeMap<Integer, String>> map;

	/** Initialize your data structure here. */
	public TimeBasedKeyValueStore() {
		map = new HashMap<>();
	}

	// Set O(lgN)
	public void set(String key, String value, int timestamp) {
		if (!map.containsKey(key)) {
			map.put(key, new TreeMap<>());
		}
		map.get(key).put(timestamp, value);
	}

	// Get O(1)
	public String get(String key, int timestamp) {
		if (!map.containsKey(key))
			return "";
		TreeMap<Integer, String> m = map.get(key);
		Integer k = m.floorKey(timestamp);
		if (k == null)
			return "";
		return m.get(k);
	}

	public class TimeBasedKeyValueStore2 {
		class Data {
			String value;
			int timestamp;

			Data(String v, int t) {
				this.value = v;
				this.timestamp = t;
			}
		}

		private final Map<String, List<Data>> map;

		/** Initialize your data structure here. */
		public TimeBasedKeyValueStore2() {
			map = new HashMap<>();
		}

		// Set O(1)
		public void set(String key, String value, int timestamp) {
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());
			map.get(key).add(new Data(value, timestamp));
		}

		// Get O(lgN)
		public String get(String key, int timestamp) {
			if (!map.containsKey(key))
				return "";
			List<Data> l = map.get(key);
			int index = binarySearch(l, timestamp);
			if (index == -1)
				return "";
			return l.get(index).value;
		}

		protected int binarySearch(List<Data> l, int timestamp) {
			int low = 0;
			int high = l.size() - 1;
			int ans = -1;
			while (low <= high) {
				int mid = (low + high) / 2;
				int val = l.get(mid).timestamp;
				if (val < timestamp) {
					ans = mid;
					low = mid + 1;
				} else if (val > timestamp) {
					high = mid - 1;
				} else if (val == timestamp) {
					return mid;
				}
			}
			return ans;
		}
	}
}
