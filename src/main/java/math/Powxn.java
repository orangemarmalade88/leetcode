package math;

public class Powxn {
	public double myPow(double x, int n) {
		return myPow(x, (long) n);
	}

	public double myPow(double x, long n) {
		if (x == 1)
			return 1;
		if (n < 0)
			return 1 / myPow(x, -n);

		double result = 1;
		double power = x;
		while (n != 0) {
			if (n % 2 != 0) {
				result *= power;
			}
			power *= power;
			n = n / 2;
		}
		return result;
	}
}
