package math;

public class FindNumbersWithEvenNumberOfDigits {
	public int findNumbers(int[] nums) {
		int count = 0;
		for (int i : nums) {
			int d = 0;
			while (i > 0) {
				i = i / 10;
				d++;
			}
			if (d % 2 == 0)
				count++;
		}
		return count;
	}
}
