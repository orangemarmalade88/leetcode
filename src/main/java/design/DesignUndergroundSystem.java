package design;

import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem {
	Map<String, Integer> times = new HashMap<>();
	Map<String, Integer> counts = new HashMap<>();
	Map<Integer, String> stations = new HashMap<>();
	Map<Integer, Integer> ts = new HashMap<>();

	public DesignUndergroundSystem() {
	}

	public void checkIn(int id, String stationName, int t) {
		stations.put(id, stationName);
		ts.put(id, t);
	}

	public void checkOut(int id, String stationName, int t) {
		String start = stations.get(id);
		String all = start + "+" + stationName;
		int time = ts.get(id);
		times.put(all, times.getOrDefault(all, 0) + t - time);
		counts.put(all, counts.getOrDefault(all, 0) + 1);
	}

	public double getAverageTime(String startStation, String endStation) {
		String all = startStation + "+" + endStation;
		int time = times.get(all);
		int count = counts.get(all);
		return (double) time / (double) count;
	}
}
