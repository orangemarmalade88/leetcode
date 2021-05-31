package game;

import java.util.ArrayDeque;
import java.util.Queue;

public class JumpGameIII {
	/*
	 * Given an array of non-negative integers arr, you are initially positioned
	 * at start index of the array. When you are at index i, you can jump to i +
	 * arr[i] or i - arr[i], check if you can reach to any index with value 0.
	 * 
	 * Notice that you can not jump outside of the array at any time.
	 * 
	 * 
	 */
	public boolean canReach(int[] arr, int start) {
		int n = arr.length;
		boolean[] visited = new boolean[n];
		Queue<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		q.add(start);
		while (!q.isEmpty()) {
			int cur = q.poll();

			if (arr[cur] == 0)
				return true;
			int i = cur - arr[cur];
			if (i >= 0 && i < n && !visited[i]) {
				q.offer(i);
				visited[i] = true;
			}
			i = cur + arr[cur];
			if (i >= 0 && i < n && !visited[i]) {
				q.offer(i);
				visited[i] = true;
			}
		}
		return false;
	}
}
