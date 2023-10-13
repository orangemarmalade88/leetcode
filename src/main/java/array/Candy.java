package array;

public class Candy {
	public int candy(int[] ratings) {
		int[] left = new int[ratings.length];
		int[] right = new int[ratings.length];

		for (int i = 1; i < left.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				left[i] = left[i - 1] + 1;
			}
		}

		for (int i = right.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				right[i] = right[i + 1] + 1;
			}
		}

		int total = ratings.length;
		for (int i = 0; i < left.length; i++) {
			total += Math.max(left[i], right[i]);
		}
		return total;
	}
}
