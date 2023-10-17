package math;

public class ValidNumber {
	public boolean isNumber(String s) {
		int i = 0;
		int n = s.length();

		// ignore sign
		if (s.charAt(i) == '+' || s.charAt(i) == '-')
			i++;

		// take a number
		boolean isNumber = false;
		while (i < n && Character.isDigit(s.charAt(i))) {
			i++;
			isNumber = true;
		}

		// take a dot AND a number
		if (i < n && s.charAt(i) == '.') {
			i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumber = true;
			}
		}

		// take E
		if (isNumber && i < n && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
			i++;
			isNumber = false;

			// take sign
			if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-'))
				i++;

			// take number
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumber = true;
			}
		}

		return isNumber && (i == n);
	}
}
