package math;

/*

 Count the number of prime numbers less than a non-negative number, n.

 */

public class CountPrimes {
	// https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	public int countPrimes(int n) {
		boolean[] isPrime = new boolean[n];

		// Initialize with all trues
		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}

		int limit = (int) Math.sqrt(n);
		for (int i = 2; i <= limit; i++) {
			if (isPrime[i]) {
				// Only count i^i, i^i+i, until n
				for (int j = i * i; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i])
				count++;
		}

		return count;
	}
}
