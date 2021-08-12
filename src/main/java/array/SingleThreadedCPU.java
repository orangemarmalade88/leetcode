package array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SingleThreadedCPU {
	public int[] getOrder(int[][] tasks) {
		int n = tasks.length;
		int[][] t = new int[n][3];
		for (int i = 0; i < n; i++) {
			t[i][0] = i;
			t[i][1] = tasks[i][0];
			t[i][2] = tasks[i][1];
		}

		Arrays.sort(t, (a, b) -> a[1] - b[1]);
		Queue<int[]> q = new PriorityQueue<>(
				(a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);

		int i = 0;
		int time = 0;
		int id = 0;
		int[] order = new int[n];
		while (i < n) {

			while (id < n && t[id][1] <= time) {
				q.offer(t[id++]);
			}
			if (q.isEmpty()) {
				time = t[id][1];
				continue;
			} else {
				int[] cur = q.poll();
				order[i++] = cur[0];
				time += cur[2];
			}
		}
		return order;
	}

}
