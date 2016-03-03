package math.conversion;

/*

 Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.

 */

public class RomantoInteger {

	public int charToInt(char c) {
		switch (c) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
		}
		return 0;
	}

	public int romanToInt(String s) {
		int result = 0;
		int current = 0;
		int prev = 0;
		for (int i = 0; i < s.length(); i++) {
			current = charToInt(s.charAt(i));
			if (current <= prev || i == 0)
				result += current;
			else
				result = result - 2 * prev + current;
			prev = current;
		}
		return result;
	}
}
