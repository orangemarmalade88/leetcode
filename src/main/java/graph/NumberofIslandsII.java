package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

 A 2d grid map of m rows and n columns is initially filled with water.
 We may perform an addLand operation which turns the water at position (row, col) into a land.
 Given a list of positions to operate, count the number of islands after each addLand operation.
 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 You may assume all four edges of the grid are all surrounded by water.

 Example:

 Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 0 0 0
 0 0 0
 0 0 0


 Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 1 0 0
 0 0 0   Number of islands = 1
 0 0 0


 Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 1 1 0
 0 0 0   Number of islands = 1
 0 0 0


 Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 1 1 0
 0 0 1   Number of islands = 2
 0 0 0


 Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 1 1 0
 0 0 1   Number of islands = 3
 0 1 0


 We return the result as an array: [1, 1, 2, 3]

 Challenge:

 Can you do it in time complexity O(k log mn), where k is the length of the positions?

 */

public class NumberofIslandsII {

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		int count = 0;

		int[] root = new int[m * n];
		List<Integer> result = new ArrayList<>();
		Arrays.fill(root, -1); // Good Stuff

		for (int[] cor : positions) {
			int id = cor[0] * n + cor[1];
			root[id] = id;
			int newRoot = id;
			count++;

			int[][] dxdy = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
			for (int[] dxy : dxdy) {
				int nx = cor[0] + dxy[0];
				int ny = cor[1] + dxy[1];
				int nid = nx * n + ny;
				// Mistake: 1D boundary check won't work for neighbor checking
				// reasons
				// (1,0) - 3 is valid but not neighbor of (0,2) - 2
				if (nx >= 0 && nx < m && ny >= 0 && ny < n && root[nid] != -1) {
					int oldRoot = find(nid, root);
					if (oldRoot != newRoot) {

						// Merge the smaller tree to the bigger tree
						root[newRoot] = oldRoot;
						newRoot = oldRoot;
						count--;
					}
				}
			}

			result.add(count);
		}
		return result;
	}

	private int find(int x, int[] root) {
		if (root[x] != x) {
			root[x] = find(root[x], root);
		}
		return root[x];
	}

}
