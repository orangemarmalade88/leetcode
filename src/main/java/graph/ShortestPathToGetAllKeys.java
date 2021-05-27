package graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class ShortestPathToGetAllKeys {
	/*
	 * We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall,
	 * "@" is the starting point, ("a", "b", ...) are keys, and ("A", "B", ...)
	 * are locks.
	 *
	 * We start at the starting point, and one move consists of walking one
	 * space in one of the 4 cardinal directions. We cannot walk outside the
	 * grid, or walk into a wall. If we walk over a key, we pick it up. We can't
	 * walk over a lock unless we have the corresponding key.
	 *
	 * For some 1 <= K <= 6, there is exactly one lowercase and one uppercase
	 * letter of the first K letters of the English alphabet in the grid. This
	 * means that there is exactly one key for each lock, and one lock for each
	 * key; and also that the letters used to represent the keys and locks were
	 * chosen in the same order as the English alphabet.
	 *
	 * Return the lowest number of moves to acquire all keys. If it's
	 * impossible, return -1.
	 *
	 */
	int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	class State {
		int x;
		int y;
		int keys;

		State(int x, int y, int keys) {
			this.x = x;
			this.y = y;
			this.keys = keys;
		}
	}

	// O(MNK)
	public int shortestPathAllKeys(String[] grid) {
		int m = grid.length;
		int n = grid[0].length();
		Queue<State> q = new ArrayDeque<>();
		Set<String> visited = new HashSet<>();

		int start_x = -1;
		int start_y = -1;
		int all_keys = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				char c = grid[i].charAt(j);
				if (c == '@') {
					start_x = i;
					start_y = j;
				} else if (c >= 'a' && c <= 'f') {
					all_keys |= 1 << (c - 'a');
				}
			}
		}
		q.offer(new State(start_x, start_y, 0));
		visited.add(start_x + " " + start_y + " " + 0);

		int steps = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				State cur = q.poll();
				if (cur.keys == all_keys)
					return steps;

				for (int[] d : directions) {
					int new_x = cur.x + d[0];
					int new_y = cur.y + d[1];
					int new_keys = cur.keys;
					if (new_x < 0 || new_x >= m || new_y < 0 || new_y >= n)
						continue;
					char c = grid[new_x].charAt(new_y);
					if (c == '#')
						continue;
					if (c <= 'f' && c >= 'a') {
						new_keys |= 1 << (c - 'a');
					} else if (c <= 'F' && c >= 'A'
							&& ((new_keys & (1 << (c - 'A'))) == 0))
						continue;
					String new_visited = new_x + " " + new_y + " " + new_keys;
					if (!visited.contains(new_visited)) {
						q.offer(new State(new_x, new_y, new_keys));
						visited.add(new_visited);
					}
				}
			}
			steps++;
		}
		return -1;

	}
}
