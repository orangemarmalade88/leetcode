package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*

 You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 -Each 0 marks an empty land which you can pass by freely.
 -Each 1 marks a building which you cannot pass through.
 -Each 2 marks an obstacle which you cannot pass through.

 For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
 1 - 0 - 2 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0

 The point (1,2) is an ideal empty land to build a house,
 as the total travel distance of 3+3+1=7 is minimal. So return 7.

 Note:
 There will be at least one building. If it is not possible to build such house
 according to the above rules, return -1.

 */

public class ShortestDistanceFromAllBuildings {

	// Very important: input is immutable! Don't change it.

	public int shortestDistance(int[][] grid) {

		int rows = grid.length;
		int cols = grid[0].length;

		List<Integer> buildings = new ArrayList<>();

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (grid[r][c] == 1) {
					buildings.add(r * cols + c);
				}
			}
		}

		int[][] sum = new int[rows][cols];

		int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 },
				{ 0, 1 } };

		boolean[][][] visited = new boolean[buildings.size()][rows][cols];

		for (int i = 0; i < buildings.size(); i++) {
			List<Integer> queue = new LinkedList<>();
			int building = buildings.get(i);
			queue.add(building);
			int level = 0;
			while (!queue.isEmpty()) {
				List<Integer> next = new LinkedList<>();
				for (int current : queue) {
					int r = current / cols;
					int c = current % cols;

					sum[r][c] += level;

					for (int[] dir : directions) {
						int newR = r + dir[0];
						int newC = c + dir[1];

						if (newR >= 0 && newR < rows && newC >= 0
								&& newC < cols && grid[newR][newC] == 0
								&& !visited[i][newR][newC]) {
							next.add(newR * cols + newC);
							visited[i][newR][newC] = true;
						}
					}
				}
				queue = next;
				level++;
			}

		}

		int min = Integer.MAX_VALUE;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				boolean allVisited = true;
				for (int i = 0; i < buildings.size(); i++) {
					allVisited &= visited[i][r][c];
				}
				if (grid[r][c] == 0 && allVisited && sum[r][c] < min)
					min = sum[r][c];
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}
}
