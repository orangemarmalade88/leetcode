package interval;

import java.util.ArrayList;
import java.util.List;

/*

 Given a sorted integer array where the range of elements are [lower, upper] inclusive, 
 return its missing ranges.

 For example, given [0, 1, 3, 50, 75], 
 lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

 */

public class MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> list = new ArrayList<>();
		int current = lower - 1;
		for (int i = 0; i < nums.length; i++) {
			current = nums[i];
			if (current > lower) {
				if (current - 1 == lower)
					list.add(Integer.toString(lower));
				else
					list.add(lower + "->" + (current - 1));
			}
			lower = current + 1;
		}

		if (lower <= upper) {
			if (lower == upper)
				list.add(Integer.toString(upper));
			else
				list.add(lower + "->" + upper);
		}

		return list;
	}
}
