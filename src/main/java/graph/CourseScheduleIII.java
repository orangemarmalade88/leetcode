package graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class CourseScheduleIII {
	public int scheduleCourse(int[][] courses) {
		Arrays.sort(courses, (a, b) -> a[1] - b[1]);
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int time = 0;
		for (int[] c : courses) {
			if (time + c[0] <= c[1]) {
				time += c[0];
				pq.offer(c[0]);
			} else if (!pq.isEmpty() && c[0] < pq.peek()) {
				time += c[0] - pq.poll();
				pq.offer(c[0]);
			}
		}
		return pq.size();
	}
}
