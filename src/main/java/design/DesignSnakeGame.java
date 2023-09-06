package design;

import java.util.LinkedList;
import java.util.Queue;

public class DesignSnakeGame {

	// Mistakes 1: row vs column
	// Mistakes 2: snake runs into its tail is ok
	// Mistakes 3: don't use board
	Queue<int[]> q = new LinkedList<>();
	boolean[][] board; // 1 = snake, 2 = food
	int m;
	int n;
	int food_id = 0;
	int cur_x = 0;
	int cur_y = 0;
	int[][] food;

	public DesignSnakeGame(int width, int height, int[][] food) {
		m = width;
		n = height;
		board = new boolean[m][n];
		q.offer(new int[] { 0, 0 });
		board[cur_x][cur_y] = true;
		this.food = food;
	}

	public int move(String direction) {
		if (direction.equals("U")) {
			cur_y--;
		} else if (direction.equals("D")) {
			cur_y++;
		} else if (direction.equals("L")) {
			cur_x--;
		} else if (direction.equals("R")) {
			cur_x++;
		}

		if (cur_x < 0 || cur_x >= m || cur_y < 0 || cur_y >= n)
			return -1;

		if (board[cur_x][cur_y]) {
			int[] last = q.peek();
			if (cur_x != last[0] || cur_y != last[1])
				return -1;
		}

		if (food_id >= food.length || food[food_id][1] != cur_x
				|| food[food_id][0] != cur_y) {
			int[] last = q.poll();
			board[last[0]][last[1]] = false;
			q.offer(new int[] { cur_x, cur_y });
			board[cur_x][cur_y] = true;
		} else {
			q.offer(new int[] { cur_x, cur_y });
			board[cur_x][cur_y] = true;
			food_id++;
		}
		return food_id;
	}
}
