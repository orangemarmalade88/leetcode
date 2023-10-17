package array.sum;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
	public int findTargetSumWays(int[] nums, int target) {
		Map<Integer, Integer> prev_map = new HashMap<>();
		prev_map.put(0, 1);
		for (int i = nums.length - 1; i >= 0; i--) {
			Map<Integer, Integer> cur_map = new HashMap<>();
			for (int pre_sum : prev_map.keySet()) {
				int pre_count = prev_map.get(pre_sum);
				cur_map.put(pre_sum + nums[i],
						cur_map.getOrDefault(pre_sum + nums[i], 0) + pre_count);
				cur_map.put(pre_sum - nums[i],
						cur_map.getOrDefault(pre_sum - nums[i], 0) + pre_count);
			}
			prev_map = cur_map;
		}
		return prev_map.getOrDefault(target, 0);
	}
}
