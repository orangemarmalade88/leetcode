package math.conversion;

/*

 The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.

 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.

 */

public class CountAndSay {
	// Other thoughts:
	// count is always < 10, even 4
	public String countAndSay(int n) {
		String prev = "1";
		while (--n > 0) {
			StringBuilder sb = new StringBuilder();
			int digit = prev.charAt(0) - '0';
			int count = 1;
			for (int i = 1; i < prev.length(); i++) {
				int cur_digit = prev.charAt(i) - '0';
				if (cur_digit == digit) {
					count++;
				} else {
					sb.append(count).append(digit);
					digit = cur_digit;
					count = 1;
				}
			}
			sb.append(count).append(digit);
			prev = sb.toString();
		}
		return prev;
	}
}
