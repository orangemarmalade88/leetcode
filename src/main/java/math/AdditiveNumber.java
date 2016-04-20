package math;

/*

 Additive number is a string whose digits can form additive sequence.

 A valid additive sequence should contain at least three numbers. Except for the first two numbers,
 each subsequent number in the sequence must be the sum of the preceding two.

 For example:
 "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199. 1 + 99 = 100, 99 + 100 = 199

 Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

 Follow up:
 How would you handle overflow for very large input integers?

 */

public class AdditiveNumber {

	// Other thoughts:
	// Use BigInteger

	public boolean isAdditiveNumber(String num) {
		return dfs(num, 0, null, null, 0);
	}

	private String add(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int l = Math.max(a.length(), b.length());
		for (int i = 0; i < l; i++) {
			int ai = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
			int bi = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
			int sum = carry + ai + bi;
			carry = sum / 10;
			int bit = sum % 10;
			sb.append(bit);
		}
		if (carry > 0)
			sb.append(carry);
		return sb.reverse().toString();
	}

	private boolean dfs(String num, int startIdx, String num0, String num1,
			int numberOfnumbers) {
		if (startIdx == num.length()) {
			if (numberOfnumbers >= 3)
				return true;
			else
				return false;
		} else {
			boolean result = false;
			for (int i = startIdx; i < num.length(); i++) {
				// Mistake: Only check when both numbers are not null
				if (num0 != null
						&& num1 != null
						&& (i + 1 - startIdx < num0.length() || i + 1
								- startIdx < num1.length()))
					continue;
				String candidate = num.substring(startIdx, i + 1);
				if (candidate.charAt(0) == '0' && candidate.length() >= 2)
					continue;
				if (num0 != null && num1 != null
						&& !candidate.equals(add(num1, num0)))
					continue;
				result |= dfs(num, i + 1, num1, candidate, numberOfnumbers + 1);
			}
			return result;
		}
	}
}
