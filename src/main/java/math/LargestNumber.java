package math;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	/*
	 * Given a list of non-negative integers nums, arrange them such that they
	 * form the largest number.
	 * 
	 * Note: The result may be very large, so you need to return a string
	 * instead of an integer.
	 * 
	 * 
	 */
	public String largestNumber(int[] nums) {
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				String x = a + b;
				String y = b + a;
				return y.compareTo(x);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (String a : strs) {
			sb.append(a);
		}
		if (sb.charAt(0) == '0')
			return "0";
		return sb.toString();
	}
}
