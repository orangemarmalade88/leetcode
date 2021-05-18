package design;

public class RandomPickWithWeight {
	/*
	 * You are given an array of positive integers w where w[i] describes the
	 * weight of ith index (0-indexed).
	 * 
	 * We need to call the function pickIndex() which randomly returns an
	 * integer in the range [0, w.length - 1]. pickIndex() should return the
	 * integer proportional to its weight in the w array. For example, for w =
	 * [1, 3], the probability of picking the index 0 is 1 / (1 + 3) = 0.25 (i.e
	 * 25%) while the probability of picking the index 1 is 3 / (1 + 3) = 0.75
	 * (i.e 75%).
	 * 
	 * More formally, the probability of picking index i is w[i] / sum(w).
	 * 
	 * 
	 */
	int total;
	int[] prefix;

	public RandomPickWithWeight(int[] w) {
		prefix = new int[w.length];
		prefix[0] = w[0];
		for (int i = 1; i < w.length; i++) {
			prefix[i] = prefix[i - 1] + w[i];
		}
		total = prefix[w.length - 1];
	}

	public int pickIndex() {
		int r = (int) Math.floor(Math.random() * total) + 1;
		return binarySearch(prefix, r);
	}

	protected int binarySearch(int[] p, int key) {
		int low = 0;
		int high = p.length - 1;
		while (low <= high) {
			int mid = (low + high + 1) / 2;
			int val = p[mid];
			if (val < key) {
				low = mid + 1;
			} else if (val > key) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return low;
	}

}
