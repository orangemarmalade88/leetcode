package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*

 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 Find all unique triplets in the array which gives the sum of zero.

 Note:

 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
 The solution set must not contain duplicate triplets.

 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)

 */

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int target = -nums[i];
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[j] + nums[k];
				if (sum < target)
					j++;
				else if (sum > target)
					k--;
				else {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(nums[k]);
					set.add(temp);
					j++;
					k--;
				}
			}
		}
		List<List<Integer>> result = new ArrayList<>();
		result.addAll(set);
		return result;
	}

	// Mistake: Don't forget to move j,k on matches

	// Extension: O(N^2) space without sorting, store pairs into hash table
	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		if (nums.length <= 2)
			return result;

		Map<Integer, List<Integer[]>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				Integer[] pair = new Integer[] { i, j };
				if (map.containsKey(sum)) {
					map.get(sum).add(pair);
				} else {
					List<Integer[]> list = new ArrayList<>();
					list.add(pair);
					map.put(sum, list);
				}
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(-nums[i])) {
				List<Integer[]> pairs = map.get(-nums[i]);
				for (Integer[] pair : pairs) {
					if (pair[0] != i && pair[1] != i) {
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[pair[0]]);
						temp.add(nums[pair[1]]);
						Collections.sort(temp);
						set.add(temp);
					}
				}
			}
		}
		result.addAll(set);
		return result;

	}
}
