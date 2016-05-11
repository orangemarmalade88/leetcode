package math;

/*

 Implement pow(x, n).

 */

public class Pow {
	public double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (x == 0 || x == 1)
			return x;
		double halfPow = myPow(x, n / 2);
		double square = halfPow * halfPow;
		if (n % 2 == 0)
			return square;
		else
			return square * (n > 0 ? x : 1 / x);
	}
}
