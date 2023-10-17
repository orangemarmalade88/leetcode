package array;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		int n = nums.length;
		int[] prefix = new int[n + 1];

		Map<Integer, Integer> map = new HashMap<>(); // mod to earliest index
		map.put(0, 0);

		for (int i = 1; i <= n; i++) {
			prefix[i] = nums[i - 1] + prefix[i - 1];
			int mod = prefix[i] % k;
			if (map.containsKey(mod)) {
				int index = map.get(mod);
				if (i - index >= 2)
					return true;
			} else {
				map.put(mod, i);
			}
		}

		return false;
	}
}
