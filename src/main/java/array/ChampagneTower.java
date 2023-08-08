package array;

public class ChampagneTower {

	// Mistakes 1: Check boundary condition [x-1]
	public static double champagneTower(int poured, int query_row,
			int query_glass) {
		double[][] tower = new double[100][100];
		tower[0][0] = poured;
		for (int y = 1; y <= query_row; y++) {
			for (int x = 0; x <= y; x++) {
				if (x - 1 >= 0 && tower[x - 1][y - 1] > 1)
					tower[x][y] += (tower[x - 1][y - 1] - 1) * 0.5;
				if (y - 1 >= 0 && tower[x][y - 1] > 1)
					tower[x][y] += (tower[x][y - 1] - 1) * 0.5;
			}
		}
		return Math.min(1, tower[query_glass][query_row]);
	}

	public static void main(String[] args) {
		champagneTower(2, 1, 1);
	}
}
