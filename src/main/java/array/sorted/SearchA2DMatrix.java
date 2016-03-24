package array.sorted;

/*

 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:


 -Integers in each row are sorted from left to right.
 -The first integer of each row is greater than the last integer of the previous row.


 For example,

 Consider the following matrix:
 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]


 Given target = 3, return true.

 */

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		int low = 0;
		int high = rows * cols - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;

			int midValue = matrix[mid / cols][mid % cols];
			if (midValue < target)
				low = mid + 1;
			else if (midValue > target)
				high = mid - 1;
			else
				return true;

		}
		return false;
	}
}
