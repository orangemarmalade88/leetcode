package interval;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII {
	public int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		Queue<Integer> pq = new PriorityQueue<>();
		for (int[] i : intervals) {
			if (!pq.isEmpty() && pq.peek() <= i[0]) {
				pq.poll();
			}
			pq.offer(i[1]);
		}
		return pq.size();
	}
}
