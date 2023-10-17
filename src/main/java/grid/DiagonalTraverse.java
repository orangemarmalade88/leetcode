package grid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverse {

	public int[] findDiagonalOrder(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		List<Integer> res = new ArrayList<>();

		int count = 0;
		for (int col = 0; col < n; col++) {
			List<Integer> partial = new ArrayList<>();
			int i = 0;
			int j = col;
			while (i < m && j >= 0) {
				partial.add(mat[i][j]);
				i++;
				j--;
			}

			if (count % 2 == 0) {
				Collections.reverse(partial);
			}
			res.addAll(partial);
			count++;
		}

		for (int row = 1; row < m; row++) {
			List<Integer> partial = new ArrayList<>();

			int i = row;
			int j = n - 1;
			while (i < m && j >= 0) {
				partial.add(mat[i][j]);
				i++;
				j--;
			}

			if (count % 2 == 0) {
				Collections.reverse(partial);
			}
			res.addAll(partial);
			count++;
		}

		int[] f = new int[m * n];
		for (int i = 0; i < m * n; i++) {
			f[i] = res.get(i);
		}
		return f;

	}
}
