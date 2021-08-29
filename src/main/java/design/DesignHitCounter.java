package design;

import java.util.TreeMap;

class DesignHitCounter {

	TreeMap<Integer, Integer> map = new TreeMap<>();

	/** Initialize your data structure here. */
	public DesignHitCounter() {

	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {
		map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {
		int sum = 0;
		for (int i : map.tailMap(timestamp - 300, false).keySet()) {
			int value = map.get(i);
			sum += value;
		}
		return sum;
	}
}