package interval;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import model.Interval;

/*

 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

 */

public class InsertInterval {

	// Follow up, check if any interval overlaps?
	// Use binary search instead

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}

		List<Interval> result = new ArrayList<>();
		for (int i = 0; i < intervals.size(); i++) {
			Interval current = intervals.get(i);
			if (current.start > newInterval.end) {
				result.add(newInterval);
				// Mistake subList [ ) inclusive - exclusive
				result.addAll(intervals.subList(i, intervals.size()));
				return result;
			} else if (current.end < newInterval.start) {
				result.add(current);
			} else {
				newInterval = new Interval(Math.min(newInterval.start,
						current.start), Math.max(newInterval.end, current.end));
			}
		}
		result.add(newInterval);
		return result;

	}

	// Do it in the original list
	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
		if (intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}

		ListIterator<Interval> iter = intervals.listIterator();
		while (iter.hasNext()) {
			Interval current = iter.next();
			if (current.start > newInterval.end) {
				iter.previous();
				iter.add(newInterval);
				return intervals;
			} else if (current.end < newInterval.start) {

			} else {
				newInterval = new Interval(Math.min(newInterval.start,
						current.start), Math.max(newInterval.end, current.end));
				iter.remove();
			}
		}
		intervals.add(newInterval);
		return intervals;
	}
}
