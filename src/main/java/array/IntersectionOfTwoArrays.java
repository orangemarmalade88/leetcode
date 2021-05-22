package array;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
	/*
	 * Given two integer arrays nums1 and nums2, return an array of their
	 * intersection. Each element in the result must be unique and you may
	 * return the result in any order.
	 *
	 *
	 */

	// O(M+N)
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> s = new HashSet<>();
		for (int i : nums1) {
			s.add(i);
		}
		Set<Integer> s2 = new HashSet<>();
		for (int i : nums2) {
			if (s.contains(i) && !s2.contains(i)) {
				s2.add(i);
			}
		}
		int[] res = new int[s2.size()];
		int i = 0;
		for (int element : s2) {
			res[i++] = element;
		}
		return res;
	}
}
