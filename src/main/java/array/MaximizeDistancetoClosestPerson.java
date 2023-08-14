package array;

public class MaximizeDistancetoClosestPerson {

	public static int maxDistToClosest(int[] seats) {

		int ans = 0;
		int max = 0;
		int count = 0;
		for (int i : seats) {
			if (i == 1)
				count = 0;
			else {
				count++;
				max = Math.max(max, count);
			}
		}

		int i = 0;
		while (seats[i] == 0 && i < seats.length) {
			i++;
		}
		ans = Math.max(ans, i);

		int j = seats.length - 1;
		while (seats[j] == 0 && j >= 0) {
			j--;
		}
		ans = Math.max(ans, seats.length - j - 1);

		return Math.max(ans, (max + 1) / 2);
	}

	public static void main(String[] args) {
		int[] input = { 1, 0, 0, 0, 1, 0, 1 };
		maxDistToClosest(input);
	}
}
