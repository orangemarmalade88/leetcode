package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TheMazeIII {

	// Mistake: reach same point with less string value

	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static String[] ps = { "r", "l", "d", "u" };

	class State {
		int x;
		int y;
		int d;
		String path;

		public State(int x, int y, int d, String path) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.path = path;
		}

	}

	public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
		Queue<State> q = new LinkedList<>();

		int m = maze.length;
		int n = maze[0].length;
		List<String> res = new ArrayList<>();

		boolean[][] visited = new boolean[m][n];
		String[][] shortPath = new String[m][n];

		for (int i = 0; i < 4; i++) {
			int next_x = ball[0] + dirs[i][0];
			int next_y = ball[1] + dirs[i][1];

			if (next_x < 0 || next_x >= m || next_y < 0 || next_y >= n
					|| maze[next_x][next_y] == 1) {
				continue;
			}
			State s = new State(ball[0], ball[1], i, ps[i]);
			q.offer(s);
		}

		boolean found = false;
		while (!q.isEmpty() && !found) {
			int size = q.size();
			while (size-- > 0) {
				State cur = q.poll();
				if (cur.x == hole[0] && cur.y == hole[1]) {
					res.add(cur.path);
					found = true;
				}
				int x = cur.x + dirs[cur.d][0];
				int y = cur.y + dirs[cur.d][1];

				if (x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == 1) {
					if (!visited[cur.x][cur.y]
							|| (visited[cur.x][cur.y] && cur.path
									.compareTo(shortPath[cur.x][cur.y]) < 0)) {
						visited[cur.x][cur.y] = true;
						shortPath[cur.x][cur.y] = cur.path;
						for (int i = 0; i < 4; i++) {
							int next_x = cur.x + dirs[i][0];
							int next_y = cur.y + dirs[i][1];
							if (next_x >= 0 && next_x < m && next_y >= 0
									&& next_y < n
									&& maze[next_x][next_y] == 0) {
								State s = new State(next_x, next_y, i,
										cur.path + ps[i]);
								q.offer(s);
							}
						}
					}
				} else {
					State s = new State(x, y, cur.d, cur.path);
					q.offer(s);
				}
			}
		}
		if (res.isEmpty())
			return "impossible";
		return Collections.min(res);
	}

	public static void main(String[] args) {
		int[][] maze = { { 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 },
				{ 0, 0, 1, 0, 0, 1, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 1 },
				{ 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 },
				{ 0, 0, 1, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
				{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
				{ 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0, 1, 0 } };
		int[] start = { 2, 4 };
		int[] destination = { 7, 6 };
		TheMazeIII t = new TheMazeIII();
		System.out.print(t.findShortestWay(maze, start, destination));
	}

}
