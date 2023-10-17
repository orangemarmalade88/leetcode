package design;

import java.util.Arrays;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		int[] count = new int[26];
		for (char c : tasks) {
			count[c - 'A']++;
		}

		Arrays.sort(count);
		int f_max = count[25];
		int idle = (f_max - 1) * n;

		for (int i = 24; i >= 0; i--) {
			idle -= Math.min(f_max - 1, count[i]); // you can fill at most f_max
													// - 1 items into idle
		}

		return tasks.length + (idle < 0 ? 0 : idle);

	}
}
