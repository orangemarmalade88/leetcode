package math;

public class FindNUniqueIntegersSumUpToZero {
	/*
	 * Given an integer n, return any array containing n unique integers such
	 * that they add up to 0.
	 *
	 *
	 */
	public int[] sumZero(int n) {
		int[] res = new int[n];
		for (int i = 1; i <= n / 2; i++) {
			res[2 * i - 2] = i;
			res[2 * i - 1] = -i;
		}
		if (n % 2 == 1)
			res[n - 1] = 0;
		return res;
	}
}
