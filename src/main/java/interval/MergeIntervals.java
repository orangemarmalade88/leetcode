package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
		int[] cur = intervals[0];
		List<int[]> list = new ArrayList<>();
		for (int i = 1; i < intervals.length; i++) {
			int[] next = intervals[i];
			if (next[0] <= cur[1]) {
				cur[1] = Math.max(cur[1], next[1]);
			} else {
				list.add(cur);
				cur = next;
			}
		}
		list.add(cur);

		int[][] res = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
