package design;

import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem {
	/*
	 * An underground railway system is keeping track of customer travel times
	 * between different stations. They are using this data to calculate the
	 * average time it takes to travel from one station to another.
	 *
	 * Implement the UndergroundSystem class:
	 *
	 * void checkIn(int id, string stationName, int t) A customer with a card ID
	 * equal to id, checks in at the station stationName at time t. A customer
	 * can only be checked into one place at a time. void checkOut(int id,
	 * string stationName, int t) A customer with a card ID equal to id, checks
	 * out from the station stationName at time t. double getAverageTime(string
	 * startStation, string endStation) Returns the average time it takes to
	 * travel from startStation to endStation. The average time is computed from
	 * all the previous traveling times from startStation to endStation that
	 * happened directly, meaning a check in at startStation followed by a check
	 * out from endStation. The time it takes to travel from startStation to
	 * endStation may be different from the time it takes to travel from
	 * endStation to startStation. There will be at least one customer that has
	 * traveled from startStation to endStation before getAverageTime is called.
	 * You may assume all calls to the checkIn and checkOut methods are
	 * consistent. If a customer checks in at time t1 then checks out at time
	 * t2, then t1 < t2. All events happen in chronological order.
	 *
	 *
	 */
	class Data {
		String start;
		int t;

		Data(String s, int t) {
			this.start = s;
			this.t = t;
		}
	}

	class TripData {
		int total;
		int trips;

		TripData(int to, int tr) {
			this.total = to;
			this.trips = tr;
		}
	}

	Map<Integer, Data> map;
	Map<String, TripData> m2;

	public DesignUndergroundSystem() {
		map = new HashMap<>();
		m2 = new HashMap<>();
	}

	// O(1)
	public void checkIn(int id, String stationName, int t) {
		map.put(id, new Data(stationName, t));
	}

	// O(1)
	public void checkOut(int id, String stationName, int t) {
		Data d = map.get(id);
		String trip = d.start + "+" + stationName;
		int time = t - d.t;
		if (!m2.containsKey(trip))
			m2.put(trip, new TripData(time, 1));
		else {
			m2.get(trip).total += time;
			m2.get(trip).trips++;
		}
		map.remove(id);
	}

	// O(1)
	public double getAverageTime(String startStation, String endStation) {
		String trip = startStation + "+" + endStation;
		TripData td = m2.get(trip);
		return (double) td.total / (double) td.trips;

	}
}
