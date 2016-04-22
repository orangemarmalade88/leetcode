package math;

/*

 Implement int sqrt(int x).

 Compute and return the square root of x.

 */

public class Sqrt {

	// Key Points:
	// Overflow case (mid * mid)

	// this question is asking for floor(sqrt(x))
	public int mySqrt(int x) {

		if (x < 0)
			throw new IllegalArgumentException("x can not be negative");

		int max = (int) Math.sqrt(Integer.MAX_VALUE);

		int begin = 0;
		int end = x;
		while (begin <= end) {
			int mid = (begin + end) >>> 1;
			if (mid > max)
				end = mid - 1;
			else {
				int sqrt = mid * mid;
				if (sqrt == x)
					return mid;
				else if (sqrt < x)
					begin = mid + 1;
				else
					end = mid - 1;
			}
		}
		return begin - 1;
	}
}
