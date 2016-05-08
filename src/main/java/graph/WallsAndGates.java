package graph;

import java.util.ArrayList;
import java.util.List;

/*

 You are given a m x n 2D grid initialized with these three possible values.
 1.-1 - A wall or an obstacle.
 2.0 - A gate.
 3.INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF
 as you may assume that the distance to a gate is less than 2147483647.

 Fill each empty room with the distance to its nearest gate.
 If it is impossible to reach a gate, it should be filled with INF.

 For example, given the 2D grid:

 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF

 After running your function, the 2D grid should be:

 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4

 */

public class WallsAndGates {
	public void wallsAndGates(int[][] rooms) {

		if (rooms.length == 0)
			return;

		int rows = rooms.length;
		int cols = rooms[0].length;

		List<int[]> current = new ArrayList<>();

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (rooms[r][c] == 0)
					current.add(new int[] { r, c });
			}
		}

		int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 },
				{ 0, -1 } };
		int levels = 1;

		while (!current.isEmpty()) {
			List<int[]> next = new ArrayList<>();
			for (int[] cor : current) {
				for (int[] dir : directions) {
					int r = cor[0] + dir[0];
					int c = cor[1] + dir[1];
					if (r >= 0 && r < rows && c >= 0 && c < cols
							&& rooms[r][c] == Integer.MAX_VALUE) {
						next.add(new int[] { r, c });
						rooms[r][c] = levels;
					}
				}
			}
			current = next;
			levels++;
		}
	}
}
