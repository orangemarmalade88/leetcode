package array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	/*
	 * Given an array of integers nums and an integer k, return the total number
	 * of continuous subarrays whose sum equals to k.
	 *
	 *
	 */
	// O(N)
	public int subarraySum(int[] nums, int k) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
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
