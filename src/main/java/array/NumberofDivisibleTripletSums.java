package array;

public class NumberofDivisibleTripletSums {
	public int divisibleTripletCount(int[] nums, int d) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int[] map = new int[d];
			for (int j = i + 1; j < nums.length; j++) {
				map[nums[j] % d]++;
				for (int k = j + 1; k < nums.length; k++) {
					int remain = (nums[i] + nums[k]) % d;
					int remain2 = d - remain;
					count += map[remain2];
				}
			}
		}
		return count;
	}
}
