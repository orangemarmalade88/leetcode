package string;

/*

 Validate if a given string is numeric.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true

 Note: It is intended for the problem statement to be ambiguous.
 You should gather all requirements up front before implementing one.

 */

public class ValidNumber {
	public boolean isNumber(String s) {
		int i = 0;
		int n = s.length();
		while (i < n && Character.isWhitespace(s.charAt(i)))
			i++;
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-'))
			i++;
		boolean isNumber = false;
		while (i < n && Character.isDigit(s.charAt(i))) {
			i++;
			isNumber = true;
		}
		if (i < n && s.charAt(i) == '.') {
			i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumber = true;
			}
		}
		if (isNumber && i < n && s.charAt(i) == 'e') {
			i++;
			isNumber = false;
			if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-'))
				i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumber = true;
			}
		}
		while (i < n && Character.isWhitespace(s.charAt(i)))
			i++;
		return isNumber && (i == n);
	}
}
