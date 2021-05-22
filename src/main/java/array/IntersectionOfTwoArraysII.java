package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
	/*
	 * Given two integer arrays nums1 and nums2, return an array of their
	 * intersection. Each element in the result must appear as many times as it
	 * shows in both arrays and you may return the result in any order.
	 *
	 *
	 */

	// O(M+N)
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums1) {
			int occur = map.getOrDefault(i, 0);
			map.put(i, occur + 1);
		}
		List<Integer> l = new ArrayList<>();
		for (int i : nums2) {
			int occur = map.getOrDefault(i, 0);
			if (occur > 0) {
				l.add(i);
				map.put(i, occur - 1);
			}
		}
		int i = 0;
		int[] res = new int[l.size()];
		for (int j : l) {
			res[i++] = j;
		}
		return res;
	}
}
