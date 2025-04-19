package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TwoOutofThree {
	public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
		Set<Integer> s1 = new HashSet<>();
		Set<Integer> s2 = new HashSet<>();
		Set<Integer> s3 = new HashSet<>();
		for (int n1 : nums1)
			s1.add(n1);
		for (int n2 : nums2)
			s2.add(n2);
		for (int n3 : nums3)
			s3.add(n3);

		Map<Integer, Integer> map = new HashMap<>();
		for (int n1 : s1) {
			map.put(n1, map.getOrDefault(n1, 0) + 1);
		}
		for (int n2 : s2) {
			map.put(n2, map.getOrDefault(n2, 0) + 1);
		}
		for (int n3 : s3) {
			map.put(n3, map.getOrDefault(n3, 0) + 1);
		}

		List<Integer> result = new ArrayList<>();
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() >= 2) {
				result.add(e.getKey());
			}
		}
		return result;
	}
}
