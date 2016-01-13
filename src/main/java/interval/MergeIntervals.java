package interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Interval;

/*

 Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].

 */

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		List<Interval> result = new ArrayList<>();
		if (intervals.size() <= 1)
			return intervals;

		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (curr.start <= prev.end) {
				// Mistake 1: merged interval end point!
				prev = new Interval(prev.start, Math.max(prev.end, curr.end));
			} else {
				result.add(prev);
				prev = curr;
			}
		}

		// Mistake 2: forgot to add prev back
		result.add(prev);

		return result;

	}
}
