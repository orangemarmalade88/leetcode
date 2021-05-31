package math;

public class BasicCalculator {
	/*
	 * Given a string s representing a valid expression, implement a basic
	 * calculator to evaluate it, and return the result of the evaluation.
	 * 
	 * Note: You are not allowed to use any built-in function which evaluates
	 * strings as mathematical expressions, such as eval().
	 * 
	 * 
	 */
	public int calculate(String s) {
		int sign = 1;
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				int count = 1;
				int j = i + 1;
				while (count > 0) {
					if (s.charAt(j) == '(')
						count++;
					else if (s.charAt(j) == ')')
						count--;
					j++;
				}
				int num = calculate(s.substring(i + 1, j - 1));
				sum += sign * num;
				sign = 1;
				i = j - 1;
			} else if (c == '-') {
				sign = -sign;
			} else if (c >= '0' && c <= '9') {
				int num = 0;
				while (i < s.length() && s.charAt(i) >= '0'
						&& s.charAt(i) <= '9') {
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				i--;
				sum += sign * num;
				sign = 1;
			}
		}
		return sum;
	}

}
