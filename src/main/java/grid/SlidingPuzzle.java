package grid;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
	public int slidingPuzzle(int[][] board) {
		StringBuilder start = new StringBuilder();
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				start.append(board[i][j]);
			}
		}

		StringBuilder target = new StringBuilder();
		for (int i = 1; i < m * n; i++) {
			target.append(i);
		}
		target.append('0');

		Queue<String> queue = new LinkedList<>();
		queue.add(start.toString());

		Set<String> visited = new HashSet<>();
		visited.add(start.toString());

		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		int steps = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				String cur = queue.poll();
				if (cur.equals(target.toString()))
					return steps;
				int index = cur.indexOf('0');
				int x = index / n;
				int y = index % n;
				for (int[] d : dirs) {
					int new_x = x + d[0];
					int new_y = y + d[1];
					if (new_x >= 0 && new_x < m && new_y >= 0 && new_y < n) {
						int new_pos = new_x * n + new_y;
						StringBuilder next = new StringBuilder(cur);
						next.setCharAt(new_pos, cur.charAt(index));
						next.setCharAt(index, cur.charAt(new_pos));
						if (!visited.contains(next.toString())) {
							visited.add(next.toString());
							queue.add(next.toString());
						}
					}
				}
			}
			steps++;
		}
		return -1;

	}
}
