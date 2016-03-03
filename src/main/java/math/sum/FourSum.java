package math.sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*

 Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 Find all unique quadruplets in the array which gives the sum of target.

 Note:

 ?Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d)
 ?The solution set must not contain duplicate quadruplets.

 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)

 */

public class FourSum {
	// O(N^2) average, O(N^4) worst case
	// To improve, sort the pairs by sub-sum, then use two pointers O(N^2lgN)
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> set = new HashSet<>();
		Map<Integer, List<Integer[]>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				if (map.containsKey(sum)) {
					map.get(sum).add(new Integer[] { i, j });
				} else {
					List<Integer[]> list = new ArrayList<>();
					list.add(new Integer[] { i, j });
					map.put(sum, list);
				}
			}
		}

		for (Integer s : map.keySet()) {
			if (map.containsKey(target - s)) {
				List<Integer[]> firstPairs = map.get(s);
				List<Integer[]> secondPairs = map.get(target - s);
				for (Integer[] p1 : firstPairs) {
					for (Integer[] p2 : secondPairs) {
						int a = p1[0];
						int b = p1[1];
						int c = p2[0];
						int d = p2[1];
						if (a == c || a == d || b == c || b == d)
							continue;
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[a]);
						temp.add(nums[b]);
						temp.add(nums[c]);
						temp.add(nums[d]);
						Collections.sort(temp);
						set.add(temp);
					}
				}
			}
		}

		List<List<Integer>> result = new ArrayList<>();
		result.addAll(set);
		return result;
	}
}
