package math;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int[] result = new int[digits.length];
		int carry = 1;
		for (int i = 0; i < digits.length; i++) {
			int digit = digits[digits.length - 1 - i];
			int sum = digit + carry;
			result[result.length - 1 - i] = sum & 1;
			carry = sum >> 1;
		}
		if (carry > 0) {
			result = new int[digits.length + 1];
			result[0] = 1;
		}
		return result;

	}
}
