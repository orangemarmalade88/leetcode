package array;

import java.util.Arrays;
import java.util.List;

public class MinimumTimetoMakeArraySumAtMostx {
	public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
		int size = nums1.size();
		int[][] combine = new int[size][2];
		int sum1 = 0, sum2 = 0;
		for (int i = 0; i < size; i++) {
			combine[i][0] = nums1.get(i);
			combine[i][1] = nums2.get(i);
			sum1 += nums1.get(i);
			sum2 += nums2.get(i);
		}

		Arrays.sort(combine, (a, b) -> Integer.compare(a[1], b[1]));

		int[][] dp = new int[size + 1][size + 1];

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]
						+ combine[i - 1][1] * j + combine[i - 1][0]);
			}
		}

		for (int i = 0; i <= size; i++) {
			if (sum1 + sum2 * i - dp[size][i] <= x)
				return i;
		}
		return -1;
	}
}
