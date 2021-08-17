package design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
	Map<String, TreeMap<Integer, String>> map = new HashMap<>();

	/** Initialize your data structure here. */
	public TimeBasedKeyValueStore() {

	}

	public void set(String key, String value, int timestamp) {
		if (!map.containsKey(key))
			map.put(key, new TreeMap<>());
		map.get(key).put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		TreeMap<Integer, String> m = map.get(key);
		if (m == null)
			return "";
		Map.Entry<Integer, String> e = m.floorEntry(timestamp);
		if (e == null)
			return "";
		return e.getValue();
	}
}
