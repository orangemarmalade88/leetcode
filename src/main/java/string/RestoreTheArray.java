package string;

public class RestoreTheArray {
	/*
	 * A program was supposed to print an array of integers. The program forgot
	 * to print whitespaces and the array is printed as a string of digits and
	 * all we know is that all integers in the array were in the range [1, k]
	 * and there are no leading zeros in the array.
	 *
	 * Given the string s and the integer k. There can be multiple ways to
	 * restore the array.
	 *
	 * Return the number of possible array that can be printed as a string s
	 * using the mentioned program.
	 *
	 * The number of ways could be very large so return it modulo 10^9 + 7
	 *
	 *
	 */

	// O(N)
	public int numberOfArrays(String s, int k) {
		int dp[] = new int[s.length() + 1];
		dp[s.length()] = 1;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				continue;
			}
			int sum = 0;
			for (int j = i + 1; j <= s.length(); j++) {
				String str = s.substring(i, j);
				long val = Long.parseLong(str);
				if (val > k)
					break;
				sum = (sum + dp[j]) % 1000000007;
			}
			dp[i] = sum;
		}
		return dp[0];
	}
}
