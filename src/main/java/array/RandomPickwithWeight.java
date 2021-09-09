package array;

import java.util.Random;

public class RandomPickwithWeight {
	int[] sum;
	int n;
	Random r = new Random();

	public RandomPickwithWeight(int[] w) {
		n = w.length;
		int s = 0;
		sum = new int[n];
		for (int i = 0; i < n; i++) {
			s += w[i];
			sum[i] = s;
		}
	}

	public int pickIndex() {
		int target = r.nextInt(sum[n - 1]);
		int low = 0;
		int high = n;
		while (low < high) {
			int mid = (low + high) / 2;
			if (sum[mid] <= target)
				low = mid + 1;
			else
				high = mid;
		}
		return low;
	}
}
