package array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			int slow = i + 1;
			int fast = nums.length - 1;
			while (slow < fast) {
				if (nums[slow] + nums[fast] + nums[i] == 0) {
					set.add(List.of(nums[i], nums[slow], nums[fast]));
					slow++;
					fast--;
				} else if (nums[slow] + nums[fast] + nums[i] > 0) {
					fast--;
				} else
					slow++;
			}
		}
		List<List<Integer>> res = new ArrayList<>(set);
		return res;
	}
}
