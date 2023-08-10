package array;

public class CapacityToShipPackagesWithinDDays {

	public static int shipWithinDays(int[] weights, int days) {
		int max = 0;
		int sum = 0;
		for (int w : weights) {
			max = Math.max(max, w);
			sum += w;
		}
		int low = max;
		int high = sum;
		while (low < high) {
			int mid = (low + high) / 2;
			if (findDays(weights, mid) > days) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	public static int findDays(int[] weights, int belt) {
		int days = 1;
		int current = 0;
		for (int i = 0; i < weights.length; i++) {
			if (current + weights[i] <= belt) {
				current += weights[i];
			} else {
				days++;
				current = weights[i];
			}
		}
		return days;
	}

	public static void main(String[] args) {
		int[] input = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		shipWithinDays(input, 5);
	}
}
