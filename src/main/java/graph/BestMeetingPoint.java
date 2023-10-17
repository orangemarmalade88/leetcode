package graph;

import java.util.ArrayList;
import java.util.List;

public class BestMeetingPoint {

	List<Integer> rows = new ArrayList<>();
	List<Integer> cols = new ArrayList<>();
	int m;
	int n;

	public int minTotalDistance(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		collectRowsInOrder(grid);
		collectColumnsInOrder(grid);
		return distance(rows) + distance(cols);
	}

	private int distance(List<Integer> list) {
		int dist = 0;
		int i = 0;
		int j = list.size() - 1;
		while (i < j) {
			dist += list.get(j--) - list.get(i++);
		}
		return dist;
	}

	private void collectRowsInOrder(int[][] grid) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					rows.add(i);
				}
			}
		}
	}

	private void collectColumnsInOrder(int[][] grid) {
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if (grid[i][j] == 1) {
					cols.add(j);
				}
			}
		}
	}

}
