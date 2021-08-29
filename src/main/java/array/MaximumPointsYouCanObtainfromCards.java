package array;

public class MaximumPointsYouCanObtainfromCards {
	// This can be optimized to O(K)
	public int maxScore(int[] cardPoints, int k) {
		int n = cardPoints.length;
		int[] left = new int[n + 1];
		int[] right = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			left[i] = cardPoints[i - 1] + left[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			right[i] = cardPoints[i] + right[i + 1];
		}

		int max = 0;
		for (int i = 0; i <= k; i++) {
			int sum = left[i] + right[n - k + i];
			max = Math.max(max, sum);
		}
		return max;
	}
}
