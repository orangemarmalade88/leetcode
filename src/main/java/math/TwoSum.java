package math;

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

		Map<Integer, Integer> number_to_index_map = new HashMap<>();
		for (int index = 0; index < nums.length; index++) {
			int current = nums[index];
			if (!number_to_index_map.containsKey(target - current))
				number_to_index_map.put(current, index);
			else
				return new int[] {
						number_to_index_map.get(target - current) + 1,
						index + 1 };
		}

		return new int[] { -1, -1 };
	}

}
