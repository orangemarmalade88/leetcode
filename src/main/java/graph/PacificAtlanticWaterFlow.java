package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PacificAtlanticWaterFlow {
	/*
	 * You are given an m x n integer matrix heights representing the height of
	 * each unit cell in a continent. The Pacific ocean touches the continent's
	 * left and top edges, and the Atlantic ocean touches the continent's right
	 * and bottom edges.
	 *
	 * Water can only flow in four directions: up, down, left, and right. Water
	 * flows from a cell to an adjacent one with an equal or lower height.
	 *
	 * Return a list of grid coordinates where water can flow to both the
	 * Pacific and Atlantic oceans.
	 *
	 *
	 */
	int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	// O(MN)
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		Deque<int[]> p_q = new ArrayDeque<>();
		boolean[][] p_visited = new boolean[heights.length][heights[0].length];
		for (int i = 0; i < heights.length; i++) {
			int[] next = new int[2];
			next[0] = i;
			next[1] = 0;
			p_q.offer(next);
		}
		for (int j = 1; j < heights[0].length; j++) {
			int[] next = new int[2];
			next[0] = 0;
			next[1] = j;
			p_q.offer(next);
		}
		bfs(heights, p_q, p_visited);

		Deque<int[]> a_q = new ArrayDeque<>();
		boolean[][] a_visited = new boolean[heights.length][heights[0].length];
		for (int i = 0; i < heights.length; i++) {
			int[] next = new int[2];
			next[0] = i;
			next[1] = heights[0].length - 1;
			a_q.offer(next);
		}
		for (int j = 0; j < heights[0].length - 1; j++) {
			int[] next = new int[2];
			next[0] = heights.length - 1;
			next[1] = j;
			a_q.offer(next);
		}
		bfs(heights, a_q, a_visited);

		List<List<Integer>> res = new ArrayList<>();
		for (int x = 0; x < heights.length; x++) {
			for (int y = 0; y < heights[0].length; y++) {
				if (a_visited[x][y] && p_visited[x][y]) {
					List<Integer> cor = new ArrayList<>();
					cor.add(x);
					cor.add(y);
					res.add(cor);
				}
			}
		}
		return res;
	}

	public void bfs(int[][] heights, Deque<int[]> queue, boolean[][] visited) {
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			visited[cur[0]][cur[1]] = true;
			int height = heights[cur[0]][cur[1]];
			for (int[] d : directions) {
				int x = cur[0] + d[0];
				int y = cur[1] + d[1];
				if (x >= 0 && x < heights.length && y >= 0
						&& y < heights[0].length && !visited[x][y]
						&& heights[cur[0]][cur[1]] <= heights[x][y]) {
					int[] next = new int[2];
					next[0] = x;
					next[1] = y;
					queue.offer(next);
				}
			}
		}
	}
}
