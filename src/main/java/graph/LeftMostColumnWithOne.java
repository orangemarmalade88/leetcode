package graph;

import java.util.List;

import model.BinaryMatrix;

public class LeftMostColumnWithOne {
	// Mistakes: 1. if left most is still Integer MAX, return -1;
	// Mistakes: 2. Check l == 1 (line 32).

	/*
	 * 1428. Leftmost Column with at Least a One
	 *
	 * (This problem is an interactive problem.)
	 *
	 * A row-sorted binary matrix means that all elements are 0 or 1 and each
	 * row of the matrix is sorted in non-decreasing order.
	 *
	 * Given a row-sorted binary matrix binaryMatrix, return the index
	 * (0-indexed) of the leftmost column with a 1 in it. If such an index does
	 * not exist, return -1.
	 *
	 * You can't access the Binary Matrix directly. You may only access the
	 * matrix using a BinaryMatrix interface:
	 *
	 * BinaryMatrix.get(row, col) returns the element of the matrix at index
	 * (row, col) (0-indexed). BinaryMatrix.dimensions() returns the dimensions
	 * of the matrix as a list of 2 elements [rows, cols], which means the
	 * matrix is rows x cols. Submissions making more than 1000 calls to
	 * BinaryMatrix.get will be judged Wrong Answer. Also, any solutions that
	 * attempt to circumvent the judge will result in disqualification.
	 *
	 * For custom testing purposes, the input will be the entire binary matrix
	 * mat. You will not have access to the binary matrix directly.
	 *
	 *
	 */
	int left_most = Integer.MAX_VALUE;

	// Method 1: Binary Search
	// O(NlogM)
	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dimensions = binaryMatrix.dimensions();
		int rows = dimensions.get(0);
		int columns = dimensions.get(1);
		for (int i = 0; i < rows; i++) {
			binarySearch(binaryMatrix, i, 0, columns - 1);
		}
		if (left_most == Integer.MAX_VALUE)
			return -1;
		return left_most;
	}

	// Find left most 1
	public void binarySearch(BinaryMatrix binaryMatrix, int row, int l, int r) {
		while (l < r) {
			int m = (l + r) / 2;
			if (binaryMatrix.get(row, m) == 1) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		if (binaryMatrix.get(row, l) == 1)
			left_most = Math.min(l, left_most);
	}

	// Method 2: search top right to bot left
	// O(N+M)
	public int leftMostColumnWithOne2(BinaryMatrix binaryMatrix) {
		List<Integer> dimensions = binaryMatrix.dimensions();
		int rows = dimensions.get(0);
		int columns = dimensions.get(1);
		int left_most = columns;

		int i = 0;
		int j = columns - 1;
		while (i < rows && j >= 0) {
			if (binaryMatrix.get(i, j) == 1) {
				left_most = j;
				j--;
			} else {
				i++;
			}
		}
		if (left_most == columns)
			return -1;
		return left_most;
	}
}
