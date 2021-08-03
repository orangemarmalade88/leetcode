package array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int slow = j + 1;
				int fast = nums.length - 1;
				while (slow < fast) {
					int sum = nums[slow] + nums[fast] + nums[i] + nums[j];
					if (sum == target) {
						set.add(List.of(nums[i], nums[j], nums[slow],
								nums[fast]));
						slow++;
						fast--;
					} else if (sum < target)
						slow++;
					else
						fast--;
				}
			}
		}
		List<List<Integer>> res = new ArrayList<>(set);
		return res;
	}
}
