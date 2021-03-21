package design;

import java.util.HashMap;
import java.util.Map;

public class Logger {
	/*
	 * 359. Logger Rate Limiter
	 *
	 * Design a logger system that receives a stream of messages along with
	 * their timestamps. Each unique message should only be printed at most
	 * every 10 seconds (i.e. a message printed at timestamp t will prevent
	 * other identical messages from being printed until timestamp t + 10).
	 *
	 * All messages will come in chronological order. Several messages may
	 * arrive at the same timestamp.
	 *
	 * Implement the Logger class:
	 *
	 * Logger() Initializes the logger object. bool shouldPrintMessage(int
	 * timestamp, string message) Returns true if the message should be printed
	 * in the given timestamp, otherwise returns false.
	 *
	 */
	Map<String, Integer> map;

	/** Initialize your data structure here. */
	public Logger() {
		map = new HashMap<>();
	}

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. If this method returns false, the message will
	 * not be printed. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (!map.containsKey(message) || (timestamp - map.get(message)) >= 10) {
			map.put(message, timestamp);
			return true;
		}
		return false;
	}
}
