package grid;

import java.util.List;

import model.BinaryMatrix;

public class LeftmostColumnwithatLeastaOne {
	BinaryMatrix mat;
	int m;
	int n;

	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		mat = binaryMatrix;
		List<Integer> l = mat.dimensions();
		m = l.get(0);
		n = l.get(1);

		int r = 0;
		int c = m - 1;
		while (r < m && c >= 0) {
			if (mat.get(r, c) == 1)
				c--;
			else
				r++;
		}
		if (c == m - 1)
			return -1;
		return c + 1;
	}
}
