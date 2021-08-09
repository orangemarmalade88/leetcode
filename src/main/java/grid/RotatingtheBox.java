package grid;

public class RotatingtheBox {
	public char[][] rotateTheBox(char[][] box) {
		int m = box.length;
		int n = box[0].length;
		char[][] res = new char[n][m];
		for (int c = 0; c < m; c++) {
			int ne = n - 1;
			int old = n - 1;
			while (old >= 0) {
				if (box[c][old] == '#') {
					res[ne][c] = '#';
					ne--;
				} else if (box[c][old] == '*') {
					res[old][c] = '*';
					ne = old;
				}
				old--;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (res[i][j] == 0)
					res[i][j] = '.';
			}
		}
		return res;
	}
}
