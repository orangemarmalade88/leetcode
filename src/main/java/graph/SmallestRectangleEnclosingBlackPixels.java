package graph;

public class SmallestRectangleEnclosingBlackPixels {

	int rows;
	int cols;

	public int minArea(char[][] image, int x, int y) {
		return -1;
	}

	private int binarySearchLeftMost(char[][] image, int start, int end) {
		if (start == end)
			return start;

		int mid = (start + end) >>> 1;
		boolean found = false;
		for (int r = 0; r < rows; r++) {
			if (image[r][mid] == '1') {
				found = true;
				break;
			}
		}
		if (found)
			return binarySearchLeftMost(image, start, mid);
		else
			return binarySearchLeftMost(image, mid + 1, end);
	}

	public class oldSolutionWithDFS {

		int leftMost, rightMost, upMost, downMost;
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int rows;
		int cols;

		public int minArea(char[][] image, int x, int y) {
			rows = image.length;
			cols = image[0].length;

			leftMost = rightMost = x;
			upMost = downMost = y;

			boolean[][] visited = new boolean[rows][cols];
			dfs(image, visited, x, y);
			return (rightMost - leftMost + 1) * (upMost - downMost + 1);
		}

		private void dfs(char[][] image, boolean[][] visited, int x, int y) {
			leftMost = Math.min(leftMost, x);
			rightMost = Math.max(rightMost, x);
			downMost = Math.min(downMost, y);
			upMost = Math.max(upMost, y);

			for (int[] dir : directions) {
				int r = x + dir[0];
				int c = y + dir[1];

				if (r >= 0 && r < rows && c >= 0 && c < cols
						&& image[r][c] == '1' && !visited[r][c]) {
					visited[r][c] = true;
					dfs(image, visited, r, c);
				}
			}
		}
	}

}
