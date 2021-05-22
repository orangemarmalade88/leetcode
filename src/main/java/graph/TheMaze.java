package graph;

public class TheMaze {
	/*
	 * There is a ball in a maze with empty spaces (represented as 0) and walls
	 * (represented as 1). The ball can go through the empty spaces by rolling
	 * up, down, left or right, but it won't stop rolling until hitting a wall.
	 * When the ball stops, it could choose the next direction.
	 * 
	 * Given the m x n maze, the ball's start position and the destination,
	 * where start = [startrow, startcol] and destination = [destinationrow,
	 * destinationcol], return true if the ball can stop at the destination,
	 * otherwise return false.
	 * 
	 * You may assume that the borders of the maze are all walls (see examples).
	 * 
	 * 
	 */
	int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	int h;
	int w;
	int[] des;

	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		h = maze.length;
		w = maze[0].length;
		des = destination;

		boolean[][][] visited = new boolean[h][w][4];
		for (int[] d : directions) {
			if (dfs(maze, visited, d, start[0], start[1]))
				return true;
		}
		return false;
	}

	public boolean dfs(int[][] maze, boolean[][][] visited, int[] direction,
			int x, int y) {
		int next_x = x + direction[0];
		int next_y = y + direction[1];
		if (next_x < 0 || next_y < 0 || next_x >= h || next_y >= w
				|| maze[next_x][next_y] == 1) {
			if (des[0] == x && des[1] == y)
				return true;
			for (int i = 0; i < 4; i++) {
				int[] d = directions[i];
				if (d[0] != direction[0] || d[1] != direction[1]) {
					int n_x = x + d[0];
					int n_y = y + d[1];
					if (n_x >= 0 && n_x < h && n_y >= 0 && n_y < w
							&& maze[n_x][n_y] == 0 && !visited[x][y][i]) {
						visited[x][y][i] = true;
						if (dfs(maze, visited, d, n_x, n_y))
							return true;
					}
				}
			}
		} else {
			if (dfs(maze, visited, direction, next_x, next_y))
				return true;
		}
		return false;

	}
}
