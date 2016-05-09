package interval;

import java.util.ArrayList;
import java.util.List;

/*

 Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

 */

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int lower = nums[i];
			int higher = nums[i];
			while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
				higher = nums[++i];
			}
			if (lower == higher)
				list.add(String.valueOf(lower));
			else
				list.add(lower + "->" + higher);
		}
		return list;
	}
}
