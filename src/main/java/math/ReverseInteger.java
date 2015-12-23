package math;

/*

 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 */

public class ReverseInteger {
	public int reverse(int x) {
		long result = 0;
		while (x != 0) {
			int last = x % 10;
			result = result * 10 + last;
			x = x / 10;
		}

		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;

		return (int) result;
	}
}
