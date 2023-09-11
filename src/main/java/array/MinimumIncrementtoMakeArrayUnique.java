package array;

import java.util.TreeMap;

public class MinimumIncrementtoMakeArrayUnique {
	public int minIncrementForUnique(int[] nums) {
		int min = 0;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		Integer cur = map.firstKey();
		while (cur != null) {
			int count = map.get(cur);
			if (count > 1) {
				map.put(cur + 1, map.getOrDefault(cur + 1, 0) + count - 1);
				min += count - 1;
			}
			cur = map.higherKey(cur);
		}
		return min;
	}
}
