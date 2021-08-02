package graph;

public class RobotBoundedInCircle {
	public boolean isRobotBounded(String instructions) {
		int x = 0;
		int y = 0;
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int d = 0;

		for (char c : instructions.toCharArray()) {
			if (c == 'L')
				d = (d + 1) % 4;
			else if (c == 'R')
				d = (d + 3) % 4;
			else {
				x += dirs[d][0];
				y += dirs[d][1];
			}

		}

		return x == 0 && y == 0 || d != 0;
	}
}
