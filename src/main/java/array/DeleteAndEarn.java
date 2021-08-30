package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteAndEarn {
	public int deleteAndEarn(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		List<Integer> l = new ArrayList<>(map.keySet());
		Collections.sort(l);

		int avoid = 0;
		int take = 0;
		for (int i : l) {
			if (map.containsKey(i - 1)) {
				int tmp = take;
				take = avoid + map.get(i) * i;
				avoid = Math.max(avoid, tmp);
			} else {
				avoid = Math.max(avoid, take);
				take = avoid + map.get(i) * i;
			}
		}
		return Math.max(avoid, take);
	}
}
