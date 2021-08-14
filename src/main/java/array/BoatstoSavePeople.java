package array;

import java.util.Map;
import java.util.TreeMap;

public class BoatstoSavePeople {
	public int numRescueBoats(int[] people, int limit) {
		TreeMap<Integer, Integer> m = new TreeMap<>();
		for (int i : people) {
			m.put(i, m.getOrDefault(i, 0) + 1);
		}
		int boats = 0;
		int w = 0;
		while (m.size() > 0) {
			boats++;
			Map.Entry<Integer, Integer> entry = m.lastEntry();
			int weight = entry.getKey();
			int count = entry.getValue();
			w += weight;
			if (count == 1)
				m.remove(weight);
			else
				m.put(weight, count - 1);

			if (m.lowerKey(limit + 1 - w) != null) {
				Map.Entry<Integer, Integer> entry2 = m
						.lowerEntry(limit + 1 - w);
				int weight2 = entry2.getKey();
				int count2 = entry2.getValue();
				w += weight2;
				if (count2 == 1)
					m.remove(weight2);
				else
					m.put(weight2, count2 - 1);
			}
			w = 0;
		}
		return boats;
	}
}
