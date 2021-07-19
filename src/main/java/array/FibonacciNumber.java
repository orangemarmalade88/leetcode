package array;

public class FibonacciNumber {
	/*
	 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
	 * Fibonacci sequence, such that each number is the sum of the two preceding
	 * ones, starting from 0 and 1. That is,
	 * 
	 * F(0) = 0, F(1) = 1 F(n) = F(n - 1) + F(n - 2), for n > 1. Given n,
	 * calculate F(n).
	 * 
	 * 
	 */
	public int fib(int n) {
		if (n <= 1)
			return n;
		int last = 0;
		int last2 = 1;
		int cur = 0;
		for (int i = 2; i <= n; i++) {
			cur = last + last2;
			last = last2;
			last2 = cur;
		}
		return cur;
	}
}