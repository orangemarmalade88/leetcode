package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KHighestRankedItemsWithinaPriceRange {
	public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing,
			int[] start, int k) {

		int r = grid.length;
		int c = grid[0].length;

		List<int[]> temp = new ArrayList<>();

		List<List<Integer>> result = new ArrayList<>();

		Queue<int[]> q = new LinkedList<>();
		q.offer(start);

		boolean[][] visited = new boolean[r][c];
		visited[start[0]][start[1]] = true;

		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		int steps = 0;
		int count = 0;
		while (!q.isEmpty() && count < k) {
			int size = q.size();
			while (size-- > 0) {
				int[] cur = q.poll();
				if (grid[cur[0]][cur[1]] >= pricing[0]
						&& grid[cur[0]][cur[1]] <= pricing[1]) {
					temp.add(new int[] { steps, grid[cur[0]][cur[1]], cur[0],
							cur[1] });
					count++;
				}
				for (int[] d : dirs) {
					int x = cur[0] + d[0];
					int y = cur[1] + d[1];
					if (x >= 0 && y >= 0 && x < r && y < c && grid[x][y] != 0
							&& !visited[x][y]) {
						q.offer(new int[] { x, y });
						visited[x][y] = true;
					}
				}
			}
			steps++;
		}

		for (int i = 0; i < temp.size() && i < k; i++) {
			result.add(List.of(temp.get(i)[2], temp.get(i)[3]));
		}

		Collections
				.sort(temp,
						(a, b) -> ((a[0] != b[0]) ? Integer.compare(a[0], b[0])
								: a[1] != b[1] ? Integer.compare(a[1], b[1])
										: a[2] != b[2]
												? Integer.compare(a[2], b[2])
												: Integer.compare(a[3], b[3])));
		return result;

	}
}
