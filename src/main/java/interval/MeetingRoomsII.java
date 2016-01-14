package interval;

import java.util.Arrays;

import model.Interval;

/*

 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 find the minimum number of conference rooms required.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return 2.

 */

public class MeetingRoomsII {

	// Other thoughts: use a heap with respect to the end time
	// Same problem: railway station arrival/departure
	public int minMeetingRooms(Interval[] intervals) {
		int l = intervals.length;
		if (l == 0)
			return 0;

		int[] startTimes = new int[l];
		int[] endTimes = new int[l];

		for (int i = 0; i < l; i++) {
			startTimes[i] = intervals[i].start;
			endTimes[i] = intervals[i].end;
		}

		Arrays.sort(startTimes);
		Arrays.sort(endTimes);

		int i = 0, j = 0;
		int activeMeetings = 0, maxMeetings = 0;
		// int highStart = 0, highEnd = 0;

		while (i < l && j < l) {
			// Careful! the - sign, this "if" means increase meeting room
			// Don't need additional room if it ends at the same time as start
			if (startTimes[i] < endTimes[j]) {
				activeMeetings++;
				if (activeMeetings > maxMeetings) {
					maxMeetings = activeMeetings;
					// highStart = startTimes[i];
					// highEnd = endTimes[j];
				}
				i++;
			} else {
				activeMeetings--;
				j++;
			}
		}
		return maxMeetings;
	}
}
