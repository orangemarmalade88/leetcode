package math;

import java.util.Arrays;

public class ValidTriangleNumber {
	/*
	 * Given an integer array nums, return the number of triplets chosen from
	 * the array that can make triangles if we take them as side lengths of a
	 * triangle.
	 *
	 *
	 */

	// O(N^2)
	public int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
				while (k < nums.length && nums[i] + nums[j] > nums[k]) {
					k++;
				}
				if (k > j)
					count += k - (j + 1);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		ValidTriangleNumber v = new ValidTriangleNumber();
		int[] nums = { 0, 0, 1, 1 };
		System.out.println(v.triangleNumber(nums));
	}
}
