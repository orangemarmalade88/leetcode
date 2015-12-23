package math;

/*

 Determine whether an integer is a palindrome. Do this without extra space.

 */

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		long div = 1;
		while (div * 10 <= x)
			div *= 10;

		while (div > 1) {
			int first = x / (int) div;
			x = x - first * (int) div;
			int last = x % 10;
			x = x / 10;
			if (first != last)
				return false;
			div = div / 100;
		}

		return true;
	}

	// Improvement1: change condition a bit to avoid using long
	// Improvement2: remove first bit: x = x % div
	// Other thoughts: Use log10 and pow(10, n)
	public boolean isPalindrome2(int x) {
		if (x < 0)
			return false;
		int div = 1;
		while (x / div >= 10)
			div *= 10;

		while (div > 1) {
			int first = x / div;
			int last = x % 10;
			if (first != last)
				return false;
			x %= div;
			x /= 10;
			div /= 100;
		}

		return true;
	}
}
