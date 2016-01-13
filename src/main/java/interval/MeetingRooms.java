package interval;

import java.util.Arrays;
import java.util.Comparator;

import model.Interval;

/*

 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 determine if a person could attend all meetings.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return false.

 */

public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		for (int i = 1; i < intervals.length; i++) {
			Interval prev = intervals[i - 1];
			Interval curr = intervals[i];
			if (curr.start < prev.end)
				return false;
		}
		return true;
	}
}
