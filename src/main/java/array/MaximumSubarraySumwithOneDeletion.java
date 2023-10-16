package array;

public class MaximumSubarraySumwithOneDeletion {
	public int maximumSum(int[] arr) {
		if (arr.length == 1)
			return arr[0];

		int sum_delete = arr[0];
		int sum_no_delete = arr[0];
		int res = Integer.MIN_VALUE;

		for (int i = 1; i < arr.length; i++) {
			sum_delete = Math.max(sum_no_delete /* delete cur item */ ,
					sum_delete + arr[i]);
			sum_no_delete = Math.max(sum_no_delete + arr[i], arr[i]);
			res = Math.max(res, Math.max(sum_delete, sum_no_delete));
		}

		return res;
	}
}
