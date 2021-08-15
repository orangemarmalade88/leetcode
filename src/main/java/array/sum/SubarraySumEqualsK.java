package array.sum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	// O(N^2)
	public int subarraySum2(int[] nums, int k) {
		int n = nums.length;
		int count = 0;
		int[] sum = new int[n + 1];
		for (int i = 0; i < n; i++) {
			sum[i + 1] = nums[i] + sum[i];
		}
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (sum[j + 1] - sum[i] == k)
					count++;
			}
		}
		return count;
	}

	// O(N)
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		int count = 0;
		for (int i : nums) {
			sum += i;
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
}
