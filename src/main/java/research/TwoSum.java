package research;

import java.util.HashMap;
import java.util.Map;

/*

 Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 must be less than index2. 

 Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2

 */

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {

		if (nums == null || nums.length < 2) {
			return new int[] { -1, -1 };
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { Math.min(i + 1, map.get(target - nums[i])),
						Math.max(i + 1, map.get(target - nums[i])) };
			} else {
				map.put(nums[i], i + 1);
			}
		}

		return new int[] { -1, -1 };

	}

	// Complexity: O(N)

}
