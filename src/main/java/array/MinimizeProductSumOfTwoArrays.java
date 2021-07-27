package array;

import java.util.Arrays;

public class MinimizeProductSumOfTwoArrays {
	/*
	 * The product sum of two equal-length arrays a and b is equal to the sum of
	 * a[i] * b[i] for all 0 <= i < a.length (0-indexed).
	 * 
	 * For example, if a = [1,2,3,4] and b = [5,2,3,1], the product sum would be
	 * 1*5 + 2*2 + 3*3 + 4*1 = 22. Given two arrays nums1 and nums2 of length n,
	 * return the minimum product sum if you are allowed to rearrange the order
	 * of the elements in nums1.
	 * 
	 * 
	 */
	public int minProductSum(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int sum = 0;
		for (int i = 0; i < nums1.length; i++) {
			sum += nums1[i] * nums2[nums2.length - 1 - i];
		}
		return sum;
	}
}
