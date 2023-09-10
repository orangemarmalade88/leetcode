package graph;

import java.util.LinkedList;
import java.util.Queue;

public class TheMazeII {
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	// x,y,dir,dir

	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
		Queue<int[]> q = new LinkedList<>();

		int m = maze.length;
		int n = maze[0].length;
		boolean[][][] visited = new boolean[m][n][4];

		for (int i = 0; i < 4; i++) {
			q.offer(new int[] { start[0], start[1], i });
			visited[start[0]][start[1]][i] = true;
		}

		int steps = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] cur = q.poll();
				int x = cur[0] + dirs[cur[2]][0];
				int y = cur[1] + dirs[cur[2]][1];
				if (x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == 1) {
					if (cur[0] == destination[0] && cur[1] == destination[1])
						return steps;
					for (int i = 0; i < 4; i++) {
						int next_x = cur[0] + dirs[i][0];
						int next_y = cur[1] + dirs[i][1];
						if (next_x >= 0 && next_x < m && next_y >= 0
								&& next_y < n && maze[next_x][next_y] == 0) {
							if (!visited[next_x][next_y][i]) {
								visited[next_x][next_y][i] = true;
								q.offer(new int[] { next_x, next_y, i });
							}
						}
					}
				} else {
					if (!visited[x][y][cur[2]]) {
						visited[x][y][cur[2]] = true;
						q.offer(new int[] { x, y, cur[2] });
					}
				}
			}
			steps++;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] maze = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 } };
		int[] start = { 0, 4 };
		int[] destination = { 4, 4 };
		TheMazeII t = new TheMazeII();
		t.shortestDistance(maze, start, destination);
	}

}
