package math;

public class AddStrings {
	/*
	 * 415. Add Strings
	 *
	 * Given two non-negative integers, num1 and num2 represented as string,
	 * return the sum of num1 and num2 as a string
	 *
	 */
	public String addStrings(String num1, String num2) {
		int carry_over = 0;
		StringBuffer result = new StringBuffer();
		for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0
				|| j >= 0; i--, j--) {
			int x = i < 0 ? 0 : num1.charAt(i) - '0';
			int y = j < 0 ? 0 : num2.charAt(j) - '0';
			int r = carry_over + x + y;
			carry_over = 0;
			if (r >= 10) {
				r = r - 10;
				carry_over = 1;
			}
			result.append(r);
		}
		if (carry_over == 1)
			result.append(1);
		result.reverse();
		return result.toString();
	}
}
