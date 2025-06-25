package graph;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
	public int robotSim(int[] commands, int[][] obstacles) {
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int dir_index = 0;
		Set<String> obs = new HashSet<>();

		for (int[] ob : obstacles) {
			obs.add(ob[0] + "," + ob[1]);
		}

		int max = 0;

		int x = 0;
		int y = 0;
		for (int c : commands) {
			if (c == -2) {
				dir_index--;
				if (dir_index < 0)
					dir_index = 3;
			} else if (c == -1) {
				dir_index++;
				if (dir_index == 4)
					dir_index = 0;
			} else {
				for (int i = 0; i < c; i++) {
					int next_x = x + dirs[dir_index][0];
					int next_y = y + dirs[dir_index][1];
					if (!obs.contains(next_x + "," + next_y)) {
						x = next_x;
						y = next_y;
					} else {
						break;
					}
				}
			}
			max = Math.max(max, x * x + y * y);
		}

		return max;
	}
}
