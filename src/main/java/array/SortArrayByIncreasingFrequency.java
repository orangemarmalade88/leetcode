package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortArrayByIncreasingFrequency {
	/*
	 * Given an array of integers nums, sort the array in increasing order based
	 * on the frequency of the values. If multiple values have the same
	 * frequency, sort them in decreasing order.
	 *
	 * Return the sorted array.
	 *
	 *
	 */
	public int[] frequencySort(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(
				map.entrySet());
		Collections.sort(list, new Comparator<>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> e1,
					Map.Entry<Integer, Integer> e2) {
				return e2.getValue() == e1.getValue()
						? e2.getKey() - e1.getKey()
						: e1.getValue() - e2.getValue();
			}
		});
		int[] res = new int[nums.length];
		int index = 0;
		for (Map.Entry<Integer, Integer> e : list) {

			for (int i = 0; i < e.getValue(); i++) {
				res[index++] = e.getKey();
			}
		}
		return res;
	}
}
