package math.conversion;

/*

 Related to question Excel Sheet Column Title

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:
 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28

 */

public class ExcelSheetColumnNumber {

	// Other thoughts:
	// calculate power of 26 by hand in each iteration to avoid using Math.pow

	public int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result += (s.charAt(i) - 'A' + 1)
					* Math.pow(26, s.length() - i - 1);
		}
		return result;
	}

	public int titleToNumber2(String s) {
		int result = 0;
		int base = 1;

		for (int i = s.length() - 1; i >= 0; i--) {
			result += (s.charAt(i) - 'A' + 1) * base;
			base *= 26;
		}
		return result;
	}
}
