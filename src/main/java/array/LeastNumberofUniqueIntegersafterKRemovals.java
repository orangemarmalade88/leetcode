package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastNumberofUniqueIntegersafterKRemovals {
	public int findLeastNumOfUniqueInts(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>(); // num - > count
		for (int n : arr) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		List<int[]> l = new ArrayList<>();
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			l.add(new int[] { e.getKey(), e.getValue() });
		}
		l.sort((a, b) -> Integer.compare(a[1], b[1]));
		int i = 0;
		for (i = 0; i < l.size(); i++) {
			if (k >= l.get(i)[1]) {
				k -= l.get(i)[1];
			} else
				return l.size() - i;
		}
		return 0;
	}
}
