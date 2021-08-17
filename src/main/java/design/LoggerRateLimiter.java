package design;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
	Map<String, Integer> map = new HashMap<>();

	/** Initialize your data structure here. */
	public LoggerRateLimiter() {

	}

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. If this method returns false, the message will
	 * not be printed. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (!map.containsKey(message)) {
			map.put(message, timestamp);
			return true;
		}
		int last = map.get(message);
		if (timestamp - last < 10) {
			return false;
		}
		map.put(message, timestamp);
		return true;

	}
}
