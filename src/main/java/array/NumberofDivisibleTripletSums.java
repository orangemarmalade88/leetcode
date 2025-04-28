package array;

public class NumberofDivisibleTripletSums {
	public int divisibleTripletCount(int[] nums, int d) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int[] map = new int[d];
			for (int j = i + 1; j < nums.length; j++) {
				int remain = d - (nums[i] + nums[j]) % d;
				count += map[remain];
				map[remain]++;
			}
		}
		return count;
	}
}
